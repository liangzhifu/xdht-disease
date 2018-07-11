package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHealthManagementInputRequest {

    @ApiModelProperty(value = "职业卫生管理情况调查表")
    private RecordHealthManagement recordHealthManagement;

    @ApiModelProperty(value = "职业卫生管理情况调查表")
    private List<RecordHealthManagementData> recordHealthManagementDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
