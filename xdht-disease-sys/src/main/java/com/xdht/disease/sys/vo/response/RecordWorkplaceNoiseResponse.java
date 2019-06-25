package com.xdht.disease.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecordWorkplaceNoiseResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "公司")
    private Long companyId;

    @ApiModelProperty(value = "工种")
    private Long workTypeId;

    @JSONField(format="yyyy-MM-dd")
    @ApiModelProperty(value = "检查时间")
    private Date inspectDate;


    @ApiModelProperty(value = "是否噪声作业")
    private String analysisResult;

    @ApiModelProperty(value = "检查位置")
    private String checkPlace;

    @ApiModelProperty(value = "接触时间")
    private BigDecimal contactTime;


    @ApiModelProperty(value = "等效声级")
    private BigDecimal soundLevel;


    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;
}