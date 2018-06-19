package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordPresentSituationInputRequest {

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）")
    private RecordPresentSituation recordPresentSituation;

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）内容表")
    private List<RecordPresentSituationData> recordPresentSituationDataList;

}
