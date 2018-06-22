package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

/**
 * Created by L on 2018/6/21.
 */
@Data
public class SysDictionaryRequest {

    @Column(name = "dictionary_name")
    @ApiModelProperty(value = "字典名称")
    private String dictionaryName;

    @ApiModelProperty(value = "字典类型")
    private Long dictionaryTypeId;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNumber;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
}
