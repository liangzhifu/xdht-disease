package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordEmployeeSummary;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecordEmployeeSummaryResponse {

    @ApiModelProperty(value = "职工体检信息")
    private RecordEmployeeSummary employeeSummary;

}