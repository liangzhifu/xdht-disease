package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/20.
 */
@Data
public class SysRoleMenuEditRequest {

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "菜单id字符串")
    private String menuIds;

}
