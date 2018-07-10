package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysKnowledgeCatalog;
import com.xdht.disease.sys.service.SysKnowledgeCatalogService;
import com.xdht.disease.sys.vo.request.SysKnowledgeCatalogRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/6/26.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysKnowledgeCatalog")
public class SysKnowledgeCatalogController {

    @Autowired
    private SysKnowledgeCatalogService sysKnowledgeCatalogService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询知识库目录列表")
    public ResponseEntity<Result<List<SysKnowledgeCatalog>>> companyOfficeList(@RequestBody SysKnowledgeCatalogRequest sysKnowledgeCatalogRequest) {
        return new ResponseEntity<>(Result.ok(sysKnowledgeCatalogService.querySysKnowledgeCatalogList(sysKnowledgeCatalogRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加知识库目录")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addCompanyOffice(@RequestBody SysKnowledgeCatalog sysKnowledgeCatalog) {
        sysKnowledgeCatalogService.addKnowledgeCatalog(sysKnowledgeCatalog);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除知识库目录")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteKnowledgeCatalog(@RequestParam Long id) {
        sysKnowledgeCatalogService.deleteKnowledgeCatalog(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改知识库目录")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateKnowledgeCatalog(@RequestBody SysKnowledgeCatalog sysKnowledgeCatalog) {
        sysKnowledgeCatalogService.updateKnowledgeCatalog(sysKnowledgeCatalog);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "知识库目录详情")
    public ResponseEntity<Result<SysKnowledgeCatalog>> getDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysKnowledgeCatalogService.selectByPrimaryKey(id)), HttpStatus.OK);
    }
    
}
