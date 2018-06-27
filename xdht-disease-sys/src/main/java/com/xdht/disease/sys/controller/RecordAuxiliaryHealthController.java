package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
import com.xdht.disease.sys.vo.response.RecordAuxiliaryHealthResponse;
import com.xdht.disease.sys.vo.response.RecordBuildingBaseDetailResponse;
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
@RequestMapping(value = "/api/v1/recordAuxiliaryHealth")
public class RecordAuxiliaryHealthController {

    @Autowired
    private RecordAuxiliaryHealthService  recordAuxiliaryHealthService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordAuxiliaryHealth>>> recordList( @RequestBody RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthService.queryList(recordAuxiliaryHealthRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordAuxiliaryHealth>>> recordPage(@RequestBody RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthService.queryListPage(recordAuxiliaryHealthRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordAuxiliaryHealth>> add( @RequestBody RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        this.recordAuxiliaryHealthService.add(recordAuxiliaryHealthRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordAuxiliaryHealth>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordAuxiliaryHealth>> update(@RequestBody RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        this.recordAuxiliaryHealthService.update(recordAuxiliaryHealthRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordAuxiliaryHealthResponse>> getRecordAuxiliaryHealthDetail(@PathVariable Long id) {
        RecordAuxiliaryHealthResponse recordAuxiliaryHealthResponse = this.recordAuxiliaryHealthService.queryAuxiliaryHealthDetail(id);
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthResponse), HttpStatus.OK);
    }


}
