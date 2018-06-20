package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/20.
 */
@Data
public class SysMenuZTreeNodeResponse {

    @ApiModelProperty(value = "菜单id")
    private Long id;

    @ApiModelProperty(value = "父级id")
    private Long pId;

    @ApiModelProperty(value = "菜单名称")
    private String name;

}
