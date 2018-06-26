package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordBuildingBase;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordBuildingBaseRequest {

    @ApiModelProperty(value = "建筑物基本情况及采光照明调查表")
    private RecordBuildingBase recordBuildingBase;

    @ApiModelProperty(value = "建筑物基本情况及采光照明调查表--调查内容")
    private List<RecordBuildingBaseData> recordBuildingBaseDataList;

}
