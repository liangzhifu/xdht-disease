package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordIndividualNoise;
import com.xdht.disease.sys.service.RecordIndividualNoiseService;
import com.xdht.disease.sys.vo.request.RecordIndividualNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualNoiseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by lzf on 2018/07/11.
*/
@RestController
@RequestMapping("/api/v1/recordIndividualNoise")
public class RecordIndividualNoiseController {

    @Autowired
    private RecordIndividualNoiseService recordIndividualNoiseService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordIndividualNoise>>> recordPage(@RequestBody RecordIndividualNoiseRequest recordIndividualNoiseRequest) {
        return new ResponseEntity<>(Result.ok(recordIndividualNoiseService.queryListPage(recordIndividualNoiseRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> add(@RequestBody RecordIndividualNoise recordIndividualNoise) {
        recordIndividualNoiseService.add(recordIndividualNoise);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@PathVariable Long id) {
        recordIndividualNoiseService.delete(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public  ResponseEntity<Result<String>> update(@RequestBody RecordIndividualNoise recordIndividualNoise) {
        recordIndividualNoiseService.update(recordIndividualNoise);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordIndividualNoise>> getRecordIndividualNoiseDetail(@PathVariable Long id) {
        RecordIndividualNoise recordIndividualNoise = this.recordIndividualNoiseService.queryNoiseDetail(id);
        return new ResponseEntity<>(Result.ok(recordIndividualNoise), HttpStatus.OK);
    }

//    @RequestMapping(value = "/echarts/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiOperation(value = "获取Echarts--详细内容")
//    public ResponseEntity<Result<RecordIndividualNoiseResponse>> getRecordIndividualNoiseEchartsDetail() {
//        List<RecordIndividualNoiseResponse> recordIndividualNoiseResponseList = this.recordIndividualNoiseService.queryNoiseEchartsDetail();
//        return new ResponseEntity<>(Result.ok(recordIndividualNoiseResponseList), HttpStatus.OK);
//    }
}
