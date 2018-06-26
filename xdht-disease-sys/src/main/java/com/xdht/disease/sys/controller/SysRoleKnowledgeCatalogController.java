package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysRoleKnowledgeCatalog;
import com.xdht.disease.sys.service.SysRoleKnowledgeCatalogService;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogQueryRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by L on 2018/6/26.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysRoleKnowledgeCatalog")
public class SysRoleKnowledgeCatalogController {
    
    @Autowired
    private SysRoleKnowledgeCatalogService sysRoleKnowledgeCatalogService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询角色知识库目录列表")
    public ResponseEntity<Result<List<SysRoleKnowledgeCatalog>>> roleKnowledgeCatalogList(@RequestBody SysRoleKnowledgeCatalogQueryRequest sysRoleKnowledgeCatalogQueryRequest) {
        return new ResponseEntity<>(Result.ok(sysRoleKnowledgeCatalogService.querySysRoleKnowledgeCatalogList(sysRoleKnowledgeCatalogQueryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改角色知识库目录")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateRoleKnowledgeCatalog(@RequestBody SysRoleKnowledgeCatalogEditRequest sysRoleKnowledgeCatalogEditRequest) {
        sysRoleKnowledgeCatalogService.updateRoleKnowledgeCatalog(sysRoleKnowledgeCatalogEditRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }
}
