package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordOtherProtectiveDetailResponse {

    @ApiModelProperty(value = "其他防护设施调查表")
    private RecordOtherProtectiveFacilities recordOtherProtective;

    @ApiModelProperty(value = "其他防护设施调查表--调查内容")
    private List<RecordOtherProtectiveFacilitiesData> recordOtherProtectiveDataList;



}
