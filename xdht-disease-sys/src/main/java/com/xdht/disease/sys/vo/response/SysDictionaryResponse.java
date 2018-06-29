package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by L on 2018/6/29.
 */
@Data
public class SysDictionaryResponse {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "字典值")
    private String dictionaryName;

    @ApiModelProperty(value = "字典类型ID")
    private Long dictionaryTypeId;

    @ApiModelProperty(value = "字典类型值")
    private String dictionaryTypeName;

}
