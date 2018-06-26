package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysPost;
import com.xdht.disease.sys.service.SysPostService;
import com.xdht.disease.sys.vo.request.SysPostRequest;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysPost")
public class SysPostController {

    @Autowired
    private SysPostService sysPostService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<SysPost>>> recordList(@RequestBody SysPostRequest sysPostRequest) {
        return new ResponseEntity<>(Result.ok(sysPostService.queryList(sysPostRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<SysPost>>> recordPage(@RequestBody SysPostRequest sysPostRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(sysPostService.queryListPage(sysPostRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<SysPost>> add(@RequestBody SysPost sysPost) {
        return new ResponseEntity<>(Result.ok(sysPostService.add(sysPost)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<SysPost>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysPostService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<SysPost>> update(@RequestBody SysPost sysPost) {
        return new ResponseEntity<>(Result.ok(sysPostService.update(sysPost)), HttpStatus.OK);
    }



}
