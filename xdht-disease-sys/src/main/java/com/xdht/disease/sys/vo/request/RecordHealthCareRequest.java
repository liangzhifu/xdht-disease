package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordHealthCare;
import com.xdht.disease.sys.model.RecordHealthCareData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHealthCareRequest {

    @ApiModelProperty(value = "职业健康监护情况调查表")
    private RecordHealthCare recordHealthCare;

    @ApiModelProperty(value = "职业健康监护情况调查表--调查内容")
    private List<RecordHealthCareData> recordHealthCareDataList;

}
