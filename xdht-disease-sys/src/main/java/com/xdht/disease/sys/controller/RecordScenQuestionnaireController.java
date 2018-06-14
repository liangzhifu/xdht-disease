
package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;
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
@RequestMapping(value = "/api/v1/recordScenQuestionnaire")
public class RecordScenQuestionnaireController {

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordScenQuestionnaire>>> recordList(@RequestBody RecordScenQuestionnaireRequest recordScenQuestionnaireRequest) {
        return new ResponseEntity<>(Result.ok(recordScenQuestionnaireService.queryList(recordScenQuestionnaireRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordScenQuestionnaire>>> recordPage(@RequestBody RecordScenQuestionnaireRequest recordScenQuestionnaireRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordScenQuestionnaireService.queryListPage(recordScenQuestionnaireRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordScenQuestionnaire>> addRecordScenQuestionnaire(@RequestBody RecordScenQuestionnaire recordScenQuestionnaire) {
        return new ResponseEntity<>(Result.ok(recordScenQuestionnaireService.addRecordScenQuestionnaire(recordScenQuestionnaire)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordScenQuestionnaire>> deleteRecordScenQuestionnaire(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordScenQuestionnaireService.deleteRecordScenQuestionnaire(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordScenQuestionnaire>> updateRecordScenQuestionnaire(@RequestBody RecordScenQuestionnaire recordScenQuestionnaire) {
        return new ResponseEntity<>(Result.ok(recordScenQuestionnaireService.updateRecordScenQuestionnaire(recordScenQuestionnaire)), HttpStatus.OK);
    }

}
