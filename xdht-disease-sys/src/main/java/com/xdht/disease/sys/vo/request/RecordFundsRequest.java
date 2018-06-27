package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.model.RecordFundsData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordFundsRequest {

    @ApiModelProperty(value = "职业病防治经费投入情况调查表")
    private RecordFunds recordFunds;

    @ApiModelProperty(value = "职业病防治经费投入情况调查表--调查内容")
    private List<RecordFundsData> recordFundsDataList;

}
