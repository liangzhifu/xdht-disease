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
public class RecordSceneRequest {

    @ApiModelProperty(value = "编号")
    private String recordNo;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(value = "分页开始位置")
    private Integer start;
}
