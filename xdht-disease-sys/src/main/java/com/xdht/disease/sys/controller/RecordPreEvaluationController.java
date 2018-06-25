package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;
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
@RequestMapping(value = "/api/v1/recordPreEvaluation")
public class RecordPreEvaluationController {

    @Autowired
    private RecordPreEvaluationService recordPreEvaluationService;

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
    public ResponseEntity<Result<String>> add(@RequestBody RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        recordPreEvaluationService.add(recordPreEvaluationInputRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> deleteRecordPreEvaluation(@PathVariable Long id) {
        recordPreEvaluationService.deleteRecordPreEvaluation(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> updateRecordPreEvaluation(@RequestBody RecordPreEvaluationInputRequest recordPreEvaluationInputRequest) {
        recordPreEvaluationService.updateRecordPreEvaluation(recordPreEvaluationInputRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取建设项目概况调查表(预评价)--详细内容")
    public ResponseEntity<Result<RecordPreEvaluationDetailResponse>> getRecordPreEvaluationDetail(@PathVariable Long id) {
        RecordPreEvaluationDetailResponse recordPreEvaluationDetailResponse = this.recordPreEvaluationService.queryRecordPreEvaluationDetail(id);
        return new ResponseEntity<>(Result.ok(recordPreEvaluationDetailResponse), HttpStatus.OK);
    }

}
