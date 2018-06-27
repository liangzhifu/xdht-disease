package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordAuxiliaryHealthRequest {

    @ApiModelProperty(value = "辅助卫生用室调查表")
    private RecordAuxiliaryHealth recordAuxiliaryHealth;

    @ApiModelProperty(value = "辅助卫生用室调查表--调查内容")
    private List<RecordAuxiliaryHealthData> recordAuxiliaryHealthDataList;



}
