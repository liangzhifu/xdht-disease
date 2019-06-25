package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by L on 2018/6/19.
 */
@Data
public class YearResponse {

    @ApiModelProperty(value = "年份")
    private String year;


}
