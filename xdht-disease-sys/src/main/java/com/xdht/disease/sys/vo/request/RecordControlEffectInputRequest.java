package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordControlEffectInputRequest {

    @ApiModelProperty(value = "建设项目概况调查表（控制效果评价）")
    private RecordControlEffect recordControlEffect;

    @ApiModelProperty(value = "建设项目内容表（控制效果评价）")
    private List<RecordControlEffectData> recordControlEffectDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
