package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordOtherProtectiveInputRequest {

    @ApiModelProperty(value = "其他防护设施调查表")
    private RecordOtherProtectiveFacilities recordOtherProtective;

    @ApiModelProperty(value = "其他防护设施调查表-内容表")
    private List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList;

}
