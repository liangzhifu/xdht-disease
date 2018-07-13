package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordWorkplaceNoiseRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    private String workshop;

    @ApiModelProperty(value = "岗位")
    private Long postId;

    @ApiModelProperty(value = "主要停留地点")
    private String stopPlace;

    @ApiModelProperty(value = "测定结果dB(A)")
    private Integer testResult;

    @ApiModelProperty(value = "噪声频谱分析结果")
    private String analysisResult;

    @ApiModelProperty(value = "检测地点")
    private String checkPlace;

    @ApiModelProperty(value = "接触时间")
    private String contactTime;


    @ApiModelProperty(value = "等效声级")
    private Integer soundLevel;


    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

}
