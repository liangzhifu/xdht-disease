package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEquipmentLayoutInputRequest {

    @ApiModelProperty(value = "设备设施布局调查表")
    private RecordEquipmentLayout recordEquipmentLayout;

    @ApiModelProperty(value = "设备设施布局调查表-内容表")
    private List<RecordEquipmentLayoutData> recordEquipmentLayoutDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;

}
