package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.service.RecordCompanySummaryService;
import com.xdht.disease.sys.vo.request.DateRequest;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryEchartsResponse;
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
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/recordCompanySummary")
public class RecordCompanySummaryController {

    @Autowired
    private RecordCompanySummaryService recordCompanySummaryService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordCompanySummary>>> recordPage(@RequestBody RecordCompanySummaryRequest recordCompanySummaryRequest) {
        return new ResponseEntity<>(Result.ok(recordCompanySummaryService.queryListPage(recordCompanySummaryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> add(@RequestBody RecordCompanySummary recordCompanySummary) {
        recordCompanySummaryService.add(recordCompanySummary);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除企业体检信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@RequestParam Long id) {
        recordCompanySummaryService.delete(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> update(@RequestBody RecordCompanySummary recordCompanySummary) {
        recordCompanySummaryService.update(recordCompanySummary);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检详情")
    public  ResponseEntity<Result<RecordCompanySummary>> getRecordCompanySummaryDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordCompanySummaryService.selectByPrimaryKey(id)), HttpStatus.OK);
    }
    @RequestMapping(value = "/echarts/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检详情")
    public  ResponseEntity<Result<RecordCompanySummaryEchartsResponse>> getRecordCompanySummaryEchartsDetail(@RequestBody DateRequest dateRequest) {
        return new ResponseEntity<>(Result.ok(recordCompanySummaryService.selectCompanySummaryEcharts(dateRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/percent/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检百分比详情")
    public  ResponseEntity<Result<RecordCompanySummaryEchartsResponse>> getRecordCompanySummaryPercentDetail(@RequestBody DateRequest dateRequest) {
        return new ResponseEntity<>(Result.ok(recordCompanySummaryService.selectCompanySummaryPercentEcharts(dateRequest)), HttpStatus.OK);
    }


}
