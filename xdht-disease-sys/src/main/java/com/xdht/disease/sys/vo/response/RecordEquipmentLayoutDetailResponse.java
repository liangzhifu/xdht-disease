package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordEquipmentLayoutDetailResponse {

    @ApiModelProperty(value = "设备设施布局调查表")
    private RecordEquipmentLayout recordEquipmentLayout;

    @ApiModelProperty(value = "设备设施布局调查表--调查内容")
    private List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList;

    @ApiModelProperty(value = "设备设施布局调查表--部门列表内容")
    private List<SysCompanyOffice> sysCompanyOfficeList;



}
