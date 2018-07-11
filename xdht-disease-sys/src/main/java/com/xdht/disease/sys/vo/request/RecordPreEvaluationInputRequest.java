package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordPreEvaluationInputRequest {

    @ApiModelProperty(value = "建设项目概况调查表")
    private RecordPreEvaluation recordPreEvaluation;

    @ApiModelProperty(value = "建设项目内容表")
    private List<RecordPreEvaluationData> recordPreEvaluationDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;

}
