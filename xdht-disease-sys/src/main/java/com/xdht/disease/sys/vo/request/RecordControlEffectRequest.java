package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordControlEffectRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String preEvaluationNo;

    @ApiModelProperty(value = "核实情况")
    private String verificationResult;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

    @ApiModelProperty(value = "页数")
    private Integer pageNumber;

    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;

}
