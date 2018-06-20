package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordIndividualProtectiveDetailResponse {

    @ApiModelProperty(value = "个体防护用品调查表")
    private RecordIndividualProtectiveEquipment recordIndividualProtective;

    @ApiModelProperty(value = "个体防护用品调查表--调查内容")
    private List<RecordIndividualProtectiveEquipmentData> recordIndividualProtectiveDataList;



}
