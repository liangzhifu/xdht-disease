package com.xdht.disease.sys.vo.request;

import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.model.RecordScene;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordSceneInputRequest {

    private RecordScene recordScene;

    private List<RecordScenQuestionnaire> recordScenQuestionnaireList;


}
