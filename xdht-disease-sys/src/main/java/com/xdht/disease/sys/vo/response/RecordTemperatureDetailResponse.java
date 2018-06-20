package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordTemperatureDetailResponse {

    @ApiModelProperty(value = "防高温设施调查表")
    private RecordTemperatureProtectionFacilities recordTemperature;

    @ApiModelProperty(value = "防高温设施调查表--调查内容")
    private List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList;



}
