package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordProductInputRequest {

    @ApiModelProperty(value = "物料及产品调查表")
    private RecordProduct recordProduct;

    @ApiModelProperty(value = "物料及产品调查表-内容表")
    private List<RecordProductData> recordProductDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
