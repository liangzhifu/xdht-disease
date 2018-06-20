package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordInformingFacilitiesDetailResponse {

    @ApiModelProperty(value = "职业病危害告知设施调查表")
    private RecordInformingFacilities recordInformingFacilities;

    @ApiModelProperty(value = "职业病危害告知设施调查表--调查内容")
    private List<RecordInformingFacilitiesData> recordInformingFacilitiesDataList;



}
