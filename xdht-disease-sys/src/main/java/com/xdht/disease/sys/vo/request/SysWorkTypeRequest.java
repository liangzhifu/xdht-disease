package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysWorkTypeRequest {
    @ApiModelProperty(value = "工种id")
    private Long id;

    @ApiModelProperty(value = "工种名称")
    private String name;
}