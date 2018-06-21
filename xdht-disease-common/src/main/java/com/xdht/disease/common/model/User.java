package com.xdht.disease.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息
 * @author lzf
 */
@Data
@ApiModel
public class User implements java.io.Serializable{

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("管理员")
    private String mgrType;

}