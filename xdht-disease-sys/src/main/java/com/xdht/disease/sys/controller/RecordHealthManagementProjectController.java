package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.RecordHealthManagementProject;
import com.xdht.disease.sys.service.RecordHealthManagementProjectService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementProjectRequest;
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
@RequestMapping(value = "/api/v1/recordHealthManagementProject")
public class RecordHealthManagementProjectController {

    @Autowired
    private RecordHealthManagementProjectService recordService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHealthManagementProject>>> recordList(@RequestBody RecordHealthManagementProjectRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHealthManagementProject>> add(@RequestBody RecordHealthManagementProject recordHealthManagementProject) {
        return new ResponseEntity<>(Result.ok(recordService.add(recordHealthManagementProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHealthManagementProject>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHealthManagementProject>> update(@RequestBody RecordHealthManagementProject recordHealthManagementProject) {
        return new ResponseEntity<>(Result.ok(recordService.update(recordHealthManagementProject)), HttpStatus.OK);
    }



}
