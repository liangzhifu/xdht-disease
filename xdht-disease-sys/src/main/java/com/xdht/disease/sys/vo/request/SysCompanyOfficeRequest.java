package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysCompanyOfficeRequest {

    @ApiModelProperty(value = "公司id")
    private Long companyId;

}
