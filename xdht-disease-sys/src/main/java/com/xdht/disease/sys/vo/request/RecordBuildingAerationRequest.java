package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.sys.model.RecordBuildingAerationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordBuildingAerationRequest {

    @ApiModelProperty(value = "建筑物采暖通风及空调调查表")
    private RecordBuildingAeration recordBuildingAeration;

    @ApiModelProperty(value = "建筑物采暖通风及空调调查表--调查内容")
    private List<RecordBuildingAerationData> recordBuildingAerationDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;


}
