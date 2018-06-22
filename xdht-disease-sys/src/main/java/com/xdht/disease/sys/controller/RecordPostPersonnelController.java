package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.service.RecordPostPersonnelService;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelInputRequest;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;
import com.xdht.disease.sys.vo.response.RecordPostPersonnelDetailResponse;
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
@RequestMapping(value = "/api/v1/recordPostPersonnel")
public class RecordPostPersonnelController {

    @Autowired
    private RecordPostPersonnelService recordService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPostPersonnel>>> recordList(@RequestBody RecordPostPersonnelRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordPostPersonnel>>> recordPage(@RequestBody RecordPostPersonnelRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryListPage(recordRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordPostPersonnel>> add(@RequestBody RecordPostPersonnelInputRequest recordPostPersonnelInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.add(recordPostPersonnelInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordPostPersonnel>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordPostPersonnel>> update(@RequestBody RecordPostPersonnelInputRequest recordPostPersonnelInputRequest) {
        return new ResponseEntity<>(Result.ok(recordService.update(recordPostPersonnelInputRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/detail/{sceneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordPostPersonnelDetailResponse>> getRecordPostPersonnelDetail(@PathVariable Long sceneId) {
        RecordPostPersonnelDetailResponse recordPostPersonnelDetailResponse = this.recordService.queryPostPersonnelDetail(sceneId);
        return new ResponseEntity<>(Result.ok(recordPostPersonnelDetailResponse), HttpStatus.OK);
    }


}
