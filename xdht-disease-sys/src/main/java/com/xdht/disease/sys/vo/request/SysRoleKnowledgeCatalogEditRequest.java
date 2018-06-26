package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/6/26.
 */
@Data
public class SysRoleKnowledgeCatalogEditRequest {

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "知识库目录id字符串")
    private String knowledgeCatalogIds;

}
