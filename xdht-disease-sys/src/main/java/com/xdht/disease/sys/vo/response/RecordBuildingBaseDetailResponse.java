package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RecordBuildingBaseDetailResponse {

    @ApiModelProperty(value = "建筑物基本情况及采光照明调查表")
    private Map<String, Object> recordBuildingBase;

    @ApiModelProperty(value = "建筑物基本情况及采光照明调查表--调查内容")
    private List<Map<String, Object>> recordBuildingBaseDataList;
}