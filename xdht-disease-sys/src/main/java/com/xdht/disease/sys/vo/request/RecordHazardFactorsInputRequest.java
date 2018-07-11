package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHazardFactorsInputRequest {

    @ApiModelProperty(value = "职业病危害因素调查表")
    private RecordHazardFactors recordHazardFactors;

    @ApiModelProperty(value = "职业病危害因素调查表-内容表")
    private List<RecordHazardFactorsData> recordHazardFactorsDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
