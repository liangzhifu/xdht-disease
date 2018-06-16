package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordControlEffectDetailResponse {

    @ApiModelProperty(value = "建设项目概况调查表（控制效果评价）")
    private RecordControlEffect recordControlEffect;

    @ApiModelProperty(value = "建设项目概况调查表（控制效果评价）--调查内容")
    private List<RecordControlEffectData> recordControlEffectDataList;

    @ApiModelProperty(value = "建设项目表（控制效果评价）--调查内容")
    private List<RecordControlEffectProject> recordControlEffectProjectList;



}
