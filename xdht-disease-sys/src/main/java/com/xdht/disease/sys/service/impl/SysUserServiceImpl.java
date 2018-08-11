package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.constant.ResultCode;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.common.exception.ServiceException;
import com.xdht.disease.common.model.TokenModel;
import com.xdht.disease.common.model.User;
import com.xdht.disease.common.util.Md5Utils;
import com.xdht.disease.sys.constant.SysConstant;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysEmployeeService;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {

    @Resource(name = "ehcacheTokenManager")
    private TokenManager tokenManager;
    @Autowired
    private ThreadLocalUserService threadLocalUserService;

    @Autowired
    private SysEmployeeService sysEmployeeService;

    @Override
    public LoginResponse createToken(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        SysUser sysUser = new SysUser();
        sysUser.setLoginCode(loginRequest.getLoginCode());
        String password = loginRequest.getPassword();
        String newPassword = Md5Utils.md5(password);
        sysUser.setPassword(newPassword);
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        sysUser = this.selectOne(sysUser);
        if (sysUser == null) {
            loginResponse.setStatus("0");
        } else {
            User user = new User();
            user.setName(sysUser.getUserName());
            user.setId(sysUser.getId());
            user.setMgrType(sysUser.getMgrType());
            TokenModel tokenModel = this.tokenManager.createToken(user);
            loginResponse.setToken(tokenModel.getToken());
            loginResponse.setUserName(sysUser.getUserName());
            loginResponse.setImageName(sysUser.getAvatar());
            loginResponse.setStatus("1");
        }
        return loginResponse;
    }

    @Override
    public PageResult<SysUser> querySysUserPage(SysUserRequest sysUserRequest) {
        Condition condition = new Condition(SysUser.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
            .andGreaterThan("id", SysConstant.adminId);
        if (sysUserRequest.getUserName() != null && !"".equals(sysUserRequest.getUserName())){
            condition.getOredCriteria().get(0).andLike("userName", "%"+sysUserRequest.getUserName()+"%");
        }
        if (sysUserRequest.getLoginCode() != null && !"".equals(sysUserRequest.getLoginCode())){
            condition.getOredCriteria().get(0).andLike("loginCode", "%"+sysUserRequest.getLoginCode()+"%");
        }
        PageHelper.startPage(sysUserRequest.getPageNumber(), sysUserRequest.getPageSize());
        List<SysUser> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysUser> pageList = new PageResult<SysUser>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public List<SysUser> querySysUserList(SysUser sysUser) {
        Condition condition = new Condition(SysUser.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                .andGreaterThan("id", SysConstant.adminId);
        if (sysUser.getUserName() != null){
            condition.getOredCriteria().get(0).andLike("userName", "%"+sysUser.getUserName()+"%");
        }
        condition.setOrderByClause("id desc");
        return this.selectByCondition(condition);
    }


    @Override
    public void addUser(SysUser sysUser) throws ServiceException {
        Condition condition = new Condition(SysUser.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
            .andEqualTo("loginCode", sysUser.getLoginCode());
        int num = this.selectCountByCondition(condition);
        if (num > 0) {
            throw new ServiceException("已存在相同登录名的用户，不能添加！");
        }
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        // 密码加密
        String password = sysUser.getPassword();
        String newPassword = Md5Utils.md5(password);
        sysUser.setPassword(newPassword);
        this.insertUseGeneratedKeys(sysUser);
    }

    @Override
    public void deleteUser(Long id) {
        SysUser sysUser = this.selectByPrimaryKey(id);
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysUser);
        // 更改职工表中对应员工的状态
        if(sysUser.getEmpId() != null){
            SysEmployee sysEmployee = new SysEmployee();
            sysEmployee.setId(sysUser.getEmpId());
            sysEmployee = this.sysEmployeeService.selectOne(sysEmployee);
            sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeService.updateByPrimaryKeySelective(sysEmployee);
        }
    }

    @Override
    public void updateUser(SysUser sysUser) {
        this.updateByPrimaryKeySelective(sysUser);
        Long empId = sysUser.getEmpId();
        if (empId != null) {
            SysEmployee sysEmployee = new SysEmployee();
            sysEmployee.setId(sysUser.getEmpId());
            sysEmployee = this.sysEmployeeService.selectOne(sysEmployee);
            sysEmployee.setEmpName(sysUser.getUserName());
            sysEmployee.setEmpSex(sysUser.getSex());
            this.sysEmployeeService.updateByPrimaryKeySelective(sysEmployee);
        }
    }

    @Override
    public ResponseEntity<Result<String>> editPassword(SysUserRequest sysUserRequest) {
        String oldPassword = sysUserRequest.getOldPassword();
        String encryptOldPassword = Md5Utils.md5(oldPassword);
        String newPassword = sysUserRequest.getNewPassword();
        String newPasswordAgain = sysUserRequest.getNewPasswordAgain();
        User user = threadLocalUserService.getUser();
        SysUser sysUser = this.selectByPrimaryKey(user.getId());
        ResponseEntity<Result<String>> resultResponseEntity = null;
        if (sysUser.getPassword().equals(encryptOldPassword) && newPassword.equals(newPasswordAgain)){
            String encryptNewPassword = Md5Utils.md5(newPassword);
            sysUser.setPassword(encryptNewPassword);
            this.updateByPrimaryKeySelective(sysUser);
            resultResponseEntity =  new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
        }else {
            if (!sysUser.getPassword().equals(oldPassword)){
                resultResponseEntity = new ResponseEntity<>(Result.error(ResultCode.VALID_FAIL, "密码错误！"), HttpStatus.MULTIPLE_CHOICES);
            }else{
                resultResponseEntity = new ResponseEntity<>(Result.error(ResultCode.FAIL, "未知错误！"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return resultResponseEntity;
    }

}
