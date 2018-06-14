package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.service.RecordPostPersonnelService;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;
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

//    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiOperation(value = "查询列表")
//    public  ResponseEntity<Result<List<RecordPostPersonnel>>> recordList(@CurrentUser User user, @RequestBody RecordPostPersonnelRequest recordRequest) {
//        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
//    }
//    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiOperation(value = "分页查询")
//    public ResponseEntity<Result<PageResult<RecordPostPersonnel>>> recordPage(@CurrentUser User user, @RequestBody RecordPostPersonnelRequest recordRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
//        return new ResponseEntity<>(Result.ok(recordService.queryListPage(recordRequest,pageNum,pageSize)), HttpStatus.OK);
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordPostPersonnel>> add(@CurrentUser User user, @RequestBody RecordPostPersonnel recordPostPersonnel) {
        return new ResponseEntity<>(Result.ok(recordService.add(recordPostPersonnel)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordPostPersonnel>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordPostPersonnel>> update(@CurrentUser User user, @RequestBody RecordPostPersonnel recordPostPersonnel) {
        return new ResponseEntity<>(Result.ok(recordService.update(recordPostPersonnel)), HttpStatus.OK);
    }



}
