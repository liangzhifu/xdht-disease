package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.model.RecordScene;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordSceneInputRequest {

    @ApiModelProperty(value = "职业卫生现场调查记录")
    private RecordScene recordScene;

    @ApiModelProperty(value = "职业卫生现场调查记录--职业卫生调查内容")
    private List<RecordScenQuestionnaire> recordScenQuestionnaireList;

}
