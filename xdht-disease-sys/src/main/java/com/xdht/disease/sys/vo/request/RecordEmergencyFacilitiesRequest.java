package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEmergencyFacilitiesRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String emergencyFacilitiesNo;

    @ApiModelProperty(value = "核实情况")
    private String verificationResult;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;


}
