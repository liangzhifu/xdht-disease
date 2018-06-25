package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordPresentSituationDetailResponse {

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）")
    private Map<String, Object> recordPresentSituation;

    @ApiModelProperty(value = "用人单位概况调查表（现状评价）--调查内容")
    private List<Map<String, Object>> recordPresentSituationDataList;




}
