package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.service.RecordHazardFactorsService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;
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
@RequestMapping(value = "/api/v1/recordHazardFactors")
public class RecordHazardFactorsController {

    @Autowired
    private RecordHazardFactorsService recordHazardFactorsService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHazardFactors>>> recordList(@RequestBody RecordHazardFactorsRequest recordHazardFactorsRequest) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsService.queryList(recordHazardFactorsRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordHazardFactors>>> recordPage(@RequestBody RecordHazardFactorsRequest recordHazardFactorsRequest) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsService.queryListPage(recordHazardFactorsRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHazardFactors>> add(@RequestBody RecordHazardFactors recordHazardFactors) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsService.add(recordHazardFactors)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHazardFactors>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHazardFactors>> update(@RequestBody RecordHazardFactors recordHazardFactors) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsService.update(recordHazardFactors)), HttpStatus.OK);
    }



}
