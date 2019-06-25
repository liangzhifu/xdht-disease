package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysCompanyOfficeRequest {

    @ApiModelProperty(value = "公司id")
    private Long companyId;
    @ApiModelProperty(value = "工种id")
    private Long id;
    @ApiModelProperty(value = "类型")
    private Integer officeType;

}
