package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
import com.xdht.disease.sys.vo.response.RecordSceneDetailResponse;
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
@RequestMapping(value = "/api/v1/recordPreEvaluation")
public class RecordPreEvaluationController {

    @Autowired
    private RecordPreEvaluationService recordPreEvaluationService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPreEvaluation>>> recordList(@RequestBody RecordPreEvaluationRequest recordPreEvaluationRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.queryList(recordPreEvaluationRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordPreEvaluation>>> pageList(@RequestBody RecordPreEvaluationRequest recordPreEvaluationRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.queryListPage(recordPreEvaluationRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPreEvaluation>> addRecordControlEffect(@RequestBody RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.add(recordPreEvaluationInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPreEvaluation>> deleteRecordPreEvaluation(@PathVariable Long id) {

        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.deleteRecordPreEvaluation(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPreEvaluation>> updateRecordPreEvaluation(@RequestBody RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.updateRecordPreEvaluation(recordPreEvaluationInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取建设项目概况调查表(预评价)--详细内容")
    public ResponseEntity<Result<RecordPreEvaluationDetailResponse>> getRecordPreEvaluationDetail(@PathVariable Long id) {
        RecordPreEvaluationDetailResponse recordPreEvaluationDetailResponse = this.recordPreEvaluationService.queryRecordPreEvaluationDetail(id);
        return new ResponseEntity<>(Result.ok(recordPreEvaluationDetailResponse), HttpStatus.OK);
    }

}
