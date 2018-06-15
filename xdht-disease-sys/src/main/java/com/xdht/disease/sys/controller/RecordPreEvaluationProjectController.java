package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPreEvaluationProject;
import com.xdht.disease.sys.service.RecordPreEvaluationProjectService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationProjectRequest;
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
@RequestMapping(value = "/api/v1/recordPreEvaluationProject")
public class RecordPreEvaluationProjectController {

    @Autowired
    private RecordPreEvaluationProjectService recordPreEvaluationProjectService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPreEvaluationProject>>> recordList(@RequestBody RecordPreEvaluationProjectRequest recordPreEvaluationProjectRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationProjectService.queryList(recordPreEvaluationProjectRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/listAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPreEvaluationProject>>> listAll() {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationProjectService.queryListAll()), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordPreEvaluationProject>> add(@RequestBody RecordPreEvaluationProject recordPreEvaluationProject) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationProjectService.add(recordPreEvaluationProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordPreEvaluationProject>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationProjectService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordPreEvaluationProject>> update(@RequestBody RecordPreEvaluationProject recordPreEvaluationProject) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationProjectService.update(recordPreEvaluationProject)), HttpStatus.OK);
    }



}
