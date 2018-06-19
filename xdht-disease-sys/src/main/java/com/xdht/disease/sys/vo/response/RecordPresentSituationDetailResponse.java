package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordPresentSituationDetailResponse {

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）")
    private RecordPresentSituation recordPresentSituation;

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）--调查内容")
    private List<RecordPresentSituationData> recordPresentSituationDataList;

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）--项目列表内容")
    private List<RecordPresentSituationProject> recordPresentSituationProjectList;



}
