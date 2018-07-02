package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class LoginResponse {

    @ApiModelProperty("token信息")
    private String token;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("登录结果 0失败 1成功")
    private String status;

    @ApiModelProperty("个人图片")
    private String imageName;

}
