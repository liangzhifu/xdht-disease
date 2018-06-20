package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEmergencyFacilitiesDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "应急设施")
    private String emergencyFacilities;

    @ApiModelProperty(value = "数量(台/套)")
    private Long number;

    @ApiModelProperty(value = "运行维护情况")
    private String operationAndMaintenance;

    @ApiModelProperty(value = "技术参数（服务半径、报警浓度、换气次数等）")
    private String technicalParameter;

    @ApiModelProperty(value = "可致急性损伤的职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;


}
