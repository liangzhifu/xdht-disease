package com.xdht.disease.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/7/2.
 */
@Data
public class RecordCompanySummaryEchartsResponse {

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "总人数")
    private Integer  counts;

    @ApiModelProperty(value = "百分比")
    private float percent;
}
