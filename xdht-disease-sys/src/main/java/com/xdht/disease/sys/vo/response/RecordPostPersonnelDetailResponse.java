package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordPostPersonnelDetailResponse {

    @ApiModelProperty(value = "岗位定员及工作制度调查表")
    private RecordPostPersonnel recordPostPersonnel;

    @ApiModelProperty(value = "岗位定员及工作制度调查表--调查内容")
    private List<RecordPostPersonnelData> recordPostPersonnelDataList;



}
