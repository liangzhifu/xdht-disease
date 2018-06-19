package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordWorkLogDetailResponse {

    @ApiModelProperty(value = "工作日写实记录表")
    private RecordWorkLog recordWorkLog;

    @ApiModelProperty(value = "工作日写实记录表--调查内容")
    private List<RecordWorkLogData> recordWorkLogDataList;

    @ApiModelProperty(value = "工作日写实记录表--部门列表内容")
    private List<SysCompanyOffice> sysCompanyOfficeList;

    @ApiModelProperty(value = "工作日写实记录表--岗位列表内容")
    private List<SysPost> sysPostList;



}
