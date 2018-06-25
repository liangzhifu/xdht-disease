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
public class RecordWorkLogDetailResponse {

    @ApiModelProperty(value = "工作日写实记录表")
    private Map<String, Object> recordWorkLog;

    @ApiModelProperty(value = "工作日写实记录表--调查内容")
    private List<Map<String, Object>> recordWorkLogDataList;




}
