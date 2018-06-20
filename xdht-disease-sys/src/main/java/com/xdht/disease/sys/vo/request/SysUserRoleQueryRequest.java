package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/20.
 */
@Data
public class SysUserRoleQueryRequest {

    @ApiModelProperty(value = "用户id")
    private Long userId;

}
