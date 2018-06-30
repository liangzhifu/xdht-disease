package com.xdht.disease.common.configure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.constant.AuthConstant;
import com.xdht.disease.common.constant.ResultCode;
import com.xdht.disease.common.core.ErrorResultMap;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.common.exception.ServiceException;
import com.xdht.disease.common.model.TokenModel;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lzf
 **/
@Log4j
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Resource(name = "ehcacheTokenManager")
    private TokenManager tokenManager;

    @Autowired
    private ThreadLocalUserService threadLocalUserService;

    //使用阿里 FastJson 作为JSON MessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,//保留空的字段
                SerializerFeature.WriteNullStringAsEmpty);//String null -> ""
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
                Result result = null;
                //业务失败的异常，如“账号或密码错误”
                if (e instanceof ServiceException) {
                    result = Result.error(ResultCode.FAIL, e.getMessage());
                    log.info(e.getMessage());
                } else if (e instanceof NoHandlerFoundException) {
                    result = Result.error(ResultCode.NOT_FOUND, "接口 [" + request.getRequestURI() + "] 不存在");
                } else if (e instanceof ServletException) {
                    result = Result.error(ResultCode.FAIL, e.getMessage());
                } else if(e instanceof MethodArgumentNotValidException){
                    List<ErrorResultMap> resultMaps = new ArrayList<ErrorResultMap>();
                    List<ObjectError> errorList=((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
                    if(!CollectionUtils.isEmpty(errorList)){
                        for(ObjectError objectError:errorList){
                            if(objectError instanceof FieldError){
                                resultMaps.add(new ErrorResultMap(objectError.getObjectName()+"."+((FieldError) objectError).getField(), objectError.getDefaultMessage()));
                            }else {
                                resultMaps.add(new ErrorResultMap(objectError.getObjectName(), objectError.getDefaultMessage()));
                            }
                        }
                    }
                    result = Result.error(ResultCode.VALID_FAIL, JSONArray.toJSON(resultMaps).toString());
                } else {
                    result = Result.error(ResultCode.INTERNAL_SERVER_ERROR, "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                    String message;
                    if (handler instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                    } else {
                        message = e.getMessage();
                    }
                    log.error(message, e);
                }
                responseResult(response, result);
                return new ModelAndView();
            }

        });
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                //验证签名
                boolean pass = validateSign(request, response, handler);
                if (pass) {
                    return true;
                } else {
                    log.warn("签名认证失败，请求接口：{"+request.getRequestURI()+"}，请求IP：{"+getIpAddress(request)+"}，请求参数：{"+JSON.toJSONString(request.getParameterMap())+"}");
                    Result result = new Result();
                    result.setCode(ResultCode.UNAUTHORIZED).setMessage("签名认证失败");
                    responseResult(response, result);
                    return false;
                }
            }
        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    /**
     * 一个简单的签名认证，规则：
     * 1. 将请求参数按ascii码排序
     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
     */
    private boolean validateSign(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String authorization = request.getHeader(AuthConstant.AUTHORIZATION) == null ?
                request.getParameter("authorization") : request.getHeader(AuthConstant.AUTHORIZATION);

        //验证token
        TokenModel model = tokenManager.getToken(authorization);
        if (tokenManager.checkToken(model)) {
            threadLocalUserService.setUser(model.getUser());
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            request.setAttribute(AuthConstant.CURRENT_USER_ID, model.getUser());
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }

}
