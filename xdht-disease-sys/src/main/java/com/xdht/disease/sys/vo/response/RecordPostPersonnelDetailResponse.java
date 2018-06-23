package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordPostPersonnelDetailResponse {

    @ApiModelProperty(value = "岗位定员及工作制度调查表")
    private Map<String, Object> recordPostPersonnel;

    @ApiModelProperty(value = "岗位定员及工作制度调查表--调查内容")
    private List<Map<String, Object>> recordPostPersonnelDataList;

}
