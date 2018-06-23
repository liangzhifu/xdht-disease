package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordScene;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordSceneDetailResponse {

    @ApiModelProperty(value = "职业卫生现场调查记录")
//    private Map<String, Object> recordScene;
    private RecordScene recordScene;

    @ApiModelProperty(value = "职业卫生现场调查记录--职业卫生调查内容")
//    private List<Map<String, Object>> recordScenQuestionnaireList;
    private List<Map<String, Object>> recordScenQuestionnaireList;

}
