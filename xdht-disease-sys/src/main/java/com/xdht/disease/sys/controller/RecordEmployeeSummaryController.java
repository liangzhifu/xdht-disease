package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.sys.service.RecordEmployeeSummaryService;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;
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

@Log4j
@RestController
@RequestMapping(value = "/api/v1/recordEmployeeSummary")
public class RecordEmployeeSummaryController {
    @Autowired
    private RecordEmployeeSummaryService recordEmployeeSummaryService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public ResponseEntity<Result<List<RecordEmployeeSummary>>> recordList(@RequestBody RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.queryList(recordEmployeeSummaryRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEmployeeSummary>>> recordPage(@RequestBody RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.queryListPage(recordEmployeeSummaryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordEmployeeSummary>> add(@RequestBody RecordEmployeeSummaryResponse recordEmployeeSummaryResponse) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.add(recordEmployeeSummaryResponse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除企业体检信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordEmployeeSummary>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordEmployeeSummary>> update(@RequestBody RecordEmployeeSummaryResponse recordEmployeeSummaryResponse) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.update(recordEmployeeSummaryResponse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检详情")
    public  ResponseEntity<Result<RecordEmployeeSummaryResponse>> getRecordEmployeeSummaryDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.getRecordEmployeeSummaryDetail(id)), HttpStatus.OK);
    }
}