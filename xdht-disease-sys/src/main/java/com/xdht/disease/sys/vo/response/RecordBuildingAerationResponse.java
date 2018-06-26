package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RecordBuildingAerationResponse {
    @ApiModelProperty(value = "建筑物采暖通风及空调调查表")
    private Map<String, Object> recordBuildingAeration;

    @ApiModelProperty(value = "建筑物采暖通风及空调调查表--调查内容")
    private List<Map<String, Object>> recordBuildingAerationDataList;
}