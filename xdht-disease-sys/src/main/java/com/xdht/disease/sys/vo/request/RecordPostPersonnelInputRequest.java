package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordPostPersonnelInputRequest {

    @ApiModelProperty(value = "工作制度表信息")
    private RecordPostPersonnel recordPostPersonnel;

    @ApiModelProperty(value = "工作制度--部门表信息")
    private List<RecordPostPersonnelData> recordPostPersonnelDataList;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;
}
