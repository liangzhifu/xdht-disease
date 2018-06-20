package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordHealthManagementDetailResponse {

    @ApiModelProperty(value = "职业卫生管理情况调查表")
    private RecordHealthManagement recordHealthManagement;

    @ApiModelProperty(value = "职业卫生管理情况调查表--调查内容")
    private List<RecordHealthManagementData> recordHealthManagementDataList;

    @ApiModelProperty(value = "职业卫生管理情况调查表--调查内容表")
    private List<RecordHealthManagementProject> recordHealthManagementProjectList;



}
