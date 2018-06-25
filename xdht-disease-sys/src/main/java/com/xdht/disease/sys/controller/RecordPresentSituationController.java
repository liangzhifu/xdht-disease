package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.service.RecordPresentSituationService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;
import com.xdht.disease.sys.vo.response.RecordPresentSituationDetailResponse;
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
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/recordPresentSituation")
public class RecordPresentSituationController {

    @Autowired
    private RecordPresentSituationService recordPresentSituationService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPresentSituation>>> recordList(@RequestBody RecordPresentSituationRequest recordPresentSituationRequest) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationService.queryList(recordPresentSituationRequest)), HttpStatus.OK);
    }


    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordPresentSituation>>> recordPage(@RequestBody RecordPresentSituationRequest recordPresentSituationRequest) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationService.queryListPage(recordPresentSituationRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> addRecordPresentSituation(@RequestBody RecordPresentSituationInputRequest recordData) {
        recordPresentSituationService.addRecordPresentSituation(recordData);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteRecordPresentSituation(@PathVariable Long id) {
        recordPresentSituationService.deleteRecordPresentSituation(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateRecordPresentSituation(@RequestBody RecordPresentSituationInputRequest recordPresentSituationInputRequest) {
        recordPresentSituationService.updateRecordPresentSituation(recordPresentSituationInputRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 用人单位概况调查表（现状评价）--详细内容")
    public ResponseEntity<Result<RecordPresentSituationDetailResponse>> getRecordPresentSituationDetail(@PathVariable Long id) {
        RecordPresentSituationDetailResponse recordPresentSituationDetailResponse = this.recordPresentSituationService.queryRecordPresentSituationDetail(id);
        return new ResponseEntity<>(Result.ok(recordPresentSituationDetailResponse), HttpStatus.OK);
    }


}
