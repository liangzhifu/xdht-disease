package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysDictionary;
import com.xdht.disease.sys.service.SysDictionaryService;
import com.xdht.disease.sys.vo.request.SysDictionaryRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by L on 2018/6/21.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysDictionary")
public class SysDictionaryController {
    
    @Autowired
    private SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询字典列表")
    public ResponseEntity<Result<PageResult<SysDictionary>>> queryList(@RequestBody SysDictionaryRequest SysDictionaryRequest) {
        return new ResponseEntity<>(Result.ok(sysDictionaryService.querySysDictionaryList(SysDictionaryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询字典列表")
    public ResponseEntity<Result<PageResult<SysDictionary>>> queryPageList(@RequestBody SysDictionaryRequest SysDictionaryRequest) {
        return new ResponseEntity<>(Result.ok(sysDictionaryService.querySysDictionaryPage(SysDictionaryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加字典")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> add(@RequestBody SysDictionary SysDictionary) {
        this.sysDictionaryService.addDictionary(SysDictionary);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除字典")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@RequestParam Long id) {
        this.sysDictionaryService.deleteDictionary(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改字典")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> update(@RequestBody SysDictionary SysDictionary) {
        this.sysDictionaryService.updateDictionary(SysDictionary);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取字典信息")
    @Authorization
    public ResponseEntity<Result<SysDictionary>> getDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysDictionaryService.selectByPrimaryKey(id)), HttpStatus.OK);
    }

}
