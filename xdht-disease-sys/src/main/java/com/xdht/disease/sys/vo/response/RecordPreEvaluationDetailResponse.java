package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.model.RecordPreEvaluationProject;
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
    private RecordPreEvaluation recordPreEvaluation;

    @ApiModelProperty(value = "建设项目概况调查表--调查内容")
    private List<RecordPreEvaluationData> recordPreEvaluationDataList;

    @ApiModelProperty(value = "建设项目表--调查内容")
    private List<RecordPreEvaluationProject> recordPreEvaluationProjectList;



}
