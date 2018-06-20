package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/20.
 */
@Data
public class SysUserRoleEditRequest {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id字符串")
    private String roleIds;

}
