package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEquipmentDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officdId;

    @ApiModelProperty(value = "工艺过程")
    private String processName;

    @ApiModelProperty(value = "设备名称")
    private String equipmentName;

    @ApiModelProperty(value = "是否噪声")
    private String equipmentNoise;

    @ApiModelProperty(value = "数量  （台/套）")
    private Long epuipmentNumber;

}
