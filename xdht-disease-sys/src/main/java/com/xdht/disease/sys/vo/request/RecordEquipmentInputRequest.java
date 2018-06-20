package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEquipmentInputRequest {

    @ApiModelProperty(value = "设备设施调查表")
    private RecordEquipment recordEquipment;

    @ApiModelProperty(value = "设备设施调查表-内容表")
    private List<RecordEquipmentData> recordEquipmentDataList;

}
