package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordIndividualProtectiveInputRequest {

    @ApiModelProperty(value = "个体防护用品调查表")
    private RecordIndividualProtectiveEquipment recordIndividualProtective;

    @ApiModelProperty(value = "个体防护用品调查表-内容表")
    private List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
