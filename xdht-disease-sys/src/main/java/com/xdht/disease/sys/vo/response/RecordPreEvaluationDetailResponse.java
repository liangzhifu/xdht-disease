package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordPreEvaluationDetailResponse {

    @ApiModelProperty(value = "建设项目概况调查表")
    private Map<String, Object> recordPreEvaluation;

    @ApiModelProperty(value = "建设项目概况调查表--调查内容")
    private List<Map<String, Object>> recordPreEvaluationDataList;

}
