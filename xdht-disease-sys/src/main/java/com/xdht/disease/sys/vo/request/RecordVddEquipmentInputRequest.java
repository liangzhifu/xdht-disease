package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.model.RecordVddEquipmentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordVddEquipmentInputRequest {

    @ApiModelProperty(value = "通风排毒除尘设施调查表")
    private RecordVddEquipment recordVddEquipment;

    @ApiModelProperty(value = "通风排毒除尘设施调查表-内容表")
    private List<RecordVddEquipmentData> recordVddEquipmentDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
