package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.constant.ResultCode;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysConstant;
import com.xdht.disease.sys.constant.SysEnum;
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

    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEmployeeSummary>>> recordPage(@RequestBody RecordEmployeeSummaryRequest recordEmployeeSummaryRequest) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.queryListPage(recordEmployeeSummaryRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<String>> add(@RequestBody RecordEmployeeSummary RecordEmployeeSummary) {
        try{
            recordEmployeeSummaryService.add(RecordEmployeeSummary);
        }
        catch(Exception e){
            return  new ResponseEntity<>(Result.error(ResultCode.FAIL ,e.getMessage()),HttpStatus.OK);

        }

        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除企业体检信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@RequestParam Long id) {
        recordEmployeeSummaryService.delete(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<String>> update(@RequestBody RecordEmployeeSummary RecordEmployeeSummary) {
        recordEmployeeSummaryService.update(RecordEmployeeSummary);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检详情")
    public  ResponseEntity<Result<RecordEmployeeSummaryResponse>> getRecordEmployeeSummaryDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.getRecordEmployeeSummaryDetail(id)), HttpStatus.OK);
    }
    @RequestMapping(value = "/echars/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询企业体检详情")
    public  ResponseEntity<Result<RecordEmployeeSummaryResponse>> getRecordEmployeeSummaryEcharsDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordEmployeeSummaryService.getRecordEmployeeSummaryEcharsDetail(id)), HttpStatus.OK);
    }
}