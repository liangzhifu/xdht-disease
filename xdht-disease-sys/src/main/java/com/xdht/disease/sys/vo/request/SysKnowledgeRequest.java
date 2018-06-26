package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/26.
 */
@Data
public class SysKnowledgeRequest {

    @ApiModelProperty(value = "知识库标题")
    private String knowledgeTitle;

    @ApiModelProperty(value = "关联知识库id")
    private Long knowledgeId;

    @ApiModelProperty(value = "目录id")
    private Long catalogId;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
