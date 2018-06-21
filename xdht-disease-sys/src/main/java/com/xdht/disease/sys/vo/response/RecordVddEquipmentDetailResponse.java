package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.model.RecordVddEquipmentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordVddEquipmentDetailResponse {

    @ApiModelProperty(value = "通风排毒除尘设施调查表")
    private RecordVddEquipment recordVddEquipment;

    @ApiModelProperty(value = "通风排毒除尘设施调查表--调查内容")
    private List<RecordVddEquipmentData> recordVddEquipmentDataList;



}
