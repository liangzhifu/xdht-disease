package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.sys.model.RecordWorkLogData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordWorkLogInputRequest {

    @ApiModelProperty(value = "工作日写实记录表")
    private RecordWorkLog recordWorkLog;

    @ApiModelProperty(value = "工作日写实记录表-内容表")
    private List<RecordWorkLogData> recordWorkLogDataList;

}
