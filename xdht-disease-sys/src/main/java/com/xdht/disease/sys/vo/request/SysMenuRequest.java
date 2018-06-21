package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysMenuRequest {

    @ApiModelProperty(value = "菜单类型")
    private String menuType;

    @ApiModelProperty(value = "是否展示")
    private String isShow;

}
