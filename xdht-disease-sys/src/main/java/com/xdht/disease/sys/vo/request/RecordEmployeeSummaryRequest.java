package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RecordEmployeeSummaryRequest {

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(value = "分页开始位置")
    private Integer start;

    @ApiModelProperty(value = "职工姓名")
    private String empName;

}