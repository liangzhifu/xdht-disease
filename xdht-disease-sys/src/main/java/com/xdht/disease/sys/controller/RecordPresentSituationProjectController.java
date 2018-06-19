package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPresentSituationProject;
import com.xdht.disease.sys.service.RecordPresentSituationProjectService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationProjectRequest;
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
@RequestMapping(value = "/api/v1/recordPresentSituationProject")
public class RecordPresentSituationProjectController {

    @Autowired
    private RecordPresentSituationProjectService recordProjectService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPresentSituationProject>>> recordList(@CurrentUser User user, @RequestBody RecordPresentSituationProjectRequest recordPresentSituationProjectRequest) {
        return new ResponseEntity<>(Result.ok(recordProjectService.queryList(recordPresentSituationProjectRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPresentSituationProject>> add(@CurrentUser User user, @RequestBody RecordPresentSituationProject recordPresentSituationProject) {
        return new ResponseEntity<>(Result.ok(recordProjectService.add(recordPresentSituationProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPresentSituationProject>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordProjectService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordPresentSituationProject>> update(@CurrentUser User user, @RequestBody RecordPresentSituationProject recordPresentSituationProject) {
        return new ResponseEntity<>(Result.ok(recordProjectService.update(recordPresentSituationProject)), HttpStatus.OK);
    }



}
