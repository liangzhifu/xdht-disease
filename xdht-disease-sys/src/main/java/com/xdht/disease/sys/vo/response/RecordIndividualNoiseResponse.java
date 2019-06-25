package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RecordIndividualNoiseResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "公司")
    private String companyId;

    @ApiModelProperty(value = "部门")
    private Long officeId;

    @ApiModelProperty(value = "工种")
    private String workTypeId;

    @ApiModelProperty(value = "检查时间")
    private String inspectDate;

    @ApiModelProperty(value = "检查年份")
    private String inspectYear;

    @ApiModelProperty(value = " 每班工作时间（h）")
    private BigDecimal workingHoursPerShift;

    @ApiModelProperty(value = " 工作日/周（d）")
    private BigDecimal workdayWeek;

    @ApiModelProperty(value = " 8h等效声级dB（A）")
    private BigDecimal soundLevel;

    @ApiModelProperty(value = "判定结果")
    private String decisionResult;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

}