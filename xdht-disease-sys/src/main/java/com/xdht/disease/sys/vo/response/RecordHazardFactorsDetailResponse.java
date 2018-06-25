package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordHazardFactorsDetailResponse {

    @ApiModelProperty(value = "职业病危害因素调查表")
    private Map<String, Object> recordHazardFactors;

    @ApiModelProperty(value = "职业病危害因素调查表--调查内容")
    private List<Map<String, Object>> recordHazardFactorsDataList;



}
