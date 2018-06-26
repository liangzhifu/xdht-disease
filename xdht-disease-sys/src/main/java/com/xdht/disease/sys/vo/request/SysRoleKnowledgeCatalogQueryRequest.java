package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/26.
 */
@Data
public class SysRoleKnowledgeCatalogQueryRequest {

    @ApiModelProperty(value = "角色id")
    private Long roleId;

}
