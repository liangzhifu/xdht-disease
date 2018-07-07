package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordAntiNoiseInputRequest {

    @ApiModelProperty(value = "防噪声设施调查表")
    private RecordAntiNoiseFacilities recordAntiNoiseFacilities;

    @ApiModelProperty(value = "防噪声设施调查表-内容表")
    private List<RecordAntiNoiseFacilitiesData> recordAntiNoiseFacilitiesDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;

}
