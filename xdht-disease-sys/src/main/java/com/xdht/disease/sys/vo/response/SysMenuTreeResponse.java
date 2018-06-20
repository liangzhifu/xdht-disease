package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/19.
 */
@Data
public class SysMenuTreeResponse {

    @ApiModelProperty(value = "菜单id")
    private Long id;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "链接")
    private String url;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "是否展开")
    private boolean isExpend;

    @ApiModelProperty(value = "子菜单")
    private List<SysMenuTreeResponse> children;
}
