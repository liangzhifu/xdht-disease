package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordEmergencyFacilitiesDetailResponse {

    @ApiModelProperty(value = "应急设施调查表")
    private RecordEmergencyFacilities recordEmergencyFacilities;

    @ApiModelProperty(value = "应急设施调查表--调查内容")
    private List<RecordEmergencyFacilitiesData> recordEmergencyFacilitiesDataList;



}
