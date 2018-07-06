package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysKnowledge;
import com.xdht.disease.sys.model.SysNotice;
import com.xdht.disease.sys.service.SysKnowledgeService;
import com.xdht.disease.sys.vo.request.SysKnowledgeRequest;
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
@RequestMapping(value = "/api/v1/sysKnowledge")
public class SysKnowledgeController {
    
    @Autowired
    private SysKnowledgeService sysKnowledgeService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询知识库列表")
    public ResponseEntity<Result<PageResult<SysKnowledge>>> rolePage(@RequestBody SysKnowledgeRequest sysKnowledgeRequest) {
        return new ResponseEntity<>(Result.ok(sysKnowledgeService.querySysKnowledgePage(sysKnowledgeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询知识库列表")
    public ResponseEntity<Result<List<SysKnowledge>>> companyOfficeList(@RequestBody SysKnowledgeRequest sysKnowledgeRequest) {
        return new ResponseEntity<>(Result.ok(sysKnowledgeService.querySysKnowledgeList(sysKnowledgeRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加知识库")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addCompanyOffice(@RequestBody SysKnowledge sysKnowledge) {
        sysKnowledgeService.addKnowledge(sysKnowledge);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除知识库")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteKnowledge(@RequestParam Long id) {
        sysKnowledgeService.deleteKnowledge(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改知识库")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateKnowledge(@RequestBody SysKnowledge sysKnowledge) {
        sysKnowledgeService.updateKnowledge(sysKnowledge);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "知识库详情")
    public ResponseEntity<Result<SysKnowledge>> getDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysKnowledgeService.selectByPrimaryKey(id)), HttpStatus.OK);
    }

}
