package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordEquipmentLayoutDetailResponse {

    @ApiModelProperty(value = "设备设施布局调查表")
    private Map<String, Object> recordEquipmentLayout;

    @ApiModelProperty(value = "设备设施布局调查表--调查内容")
    private List<Map<String, Object>> recordEquipmentLayoutDataList;




}
