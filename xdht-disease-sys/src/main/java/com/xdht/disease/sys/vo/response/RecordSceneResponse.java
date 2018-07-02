package com.xdht.disease.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/6/29.
 */
@Data
public class RecordSceneResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String recordNo;

    @ApiModelProperty(value = "调查项目")
    private String projectName;

    @ApiModelProperty(value = "调查类型id")
    private Long inquiryType;

    @ApiModelProperty(value = "调查类型")
    private String inquiryTypeName;

    @ApiModelProperty(value = "调查人")
    private String inquiryPerson;

    @ApiModelProperty(value = "调查对象")
    private Long inquiryCompany;

    @ApiModelProperty(value = "调查对象名称")
    private String inquiryCompanyName;

    @ApiModelProperty(value = "陪同人")
    private Long inquiryCompanyEmployee;

    @ApiModelProperty(value = "陪同人名称")
    private String inquiryCompanyEmployeeName;

    @ApiModelProperty(value = "调查日期")
    @JSONField(format = "yyyy-MM-dd")
    private Date inquiryDate;

    @ApiModelProperty(value = "调查年份")
    private Integer inquiryYear;

}
