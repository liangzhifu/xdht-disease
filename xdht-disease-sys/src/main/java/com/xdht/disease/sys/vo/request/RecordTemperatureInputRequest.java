package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordTemperatureInputRequest {

    @ApiModelProperty(value = "防高温设施调查表")
    private RecordTemperatureProtectionFacilities recordTemperature;

    @ApiModelProperty(value = "防高温设施调查表-内容表")
    private List<RecordTemperatureProtectionFacilitiesData> recordTemperatureDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;

}
