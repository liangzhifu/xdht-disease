package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.sys.service.RecordBuildingAerationService;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationRequest;
import com.xdht.disease.sys.vo.response.RecordBuildingAerationResponse;
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
@RequestMapping(value = "/api/v1/recordBuildingAeration")
public class RecordBuildingAerationController {

    @Autowired
    private RecordBuildingAerationService recordBuildingAerationService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordBuildingAeration>>> recordList(@CurrentUser User user, @RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.queryList(recordBuildingAerationRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordBuildingAeration>>> recordPage(@CurrentUser User user, @RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.queryListPage(recordBuildingAerationRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordBuildingAeration>> add( @RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest) {
        this.recordBuildingAerationService.add(recordBuildingAerationRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordBuildingAeration>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordBuildingAeration>> update(@RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest) {
        this.recordBuildingAerationService.update(recordBuildingAerationRequest);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordBuildingAerationResponse>> getRecordBuildingAerationDetail(@PathVariable Long id) {
        RecordBuildingAerationResponse recordBuildingAerationResponse = this.recordBuildingAerationService.queryBuildingAerationDetail(id);
        return new ResponseEntity<>(Result.ok(recordBuildingAerationResponse), HttpStatus.OK);
    }


}
