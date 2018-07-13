package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.service.RecordWorkplaceNoiseService;
import com.xdht.disease.sys.vo.request.RecordWorkplaceNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;
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
@RequestMapping("/api/v1/recordWorkplaceNoise")
public class RecordWorkplaceNoiseController {

    @Autowired
    private RecordWorkplaceNoiseService recordWorkplaceNoiseService;

    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordWorkplaceNoise>>> recordPage(@RequestBody RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkplaceNoiseService.queryListPage(recordWorkplaceNoiseRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> add(@RequestBody RecordWorkplaceNoise recordWorkplaceNoise) {
        recordWorkplaceNoiseService.add(recordWorkplaceNoise);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<String>> delete(@PathVariable Long id) {
        recordWorkplaceNoiseService.delete(id);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public  ResponseEntity<Result<String>> update(@RequestBody RecordWorkplaceNoise recordWorkplaceNoise) {
        recordWorkplaceNoiseService.update(recordWorkplaceNoise);
        return new ResponseEntity<>(Result.ok(SysEnum.ResultEnum.RESULT_SUCCESS.getCode()), HttpStatus.OK);
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordWorkplaceNoise>> getRecordWorkplaceNoiseDetail(@PathVariable Long id) {
        RecordWorkplaceNoise recordWorkplaceNoise = this.recordWorkplaceNoiseService.queryNoiseDetail(id);
        return new ResponseEntity<>(Result.ok(recordWorkplaceNoise), HttpStatus.OK);
    }
    @RequestMapping(value = "/echarts/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取echarts--详细内容")
    public ResponseEntity<Result<RecordWorkplaceNoiseResponse>> getRecordWorkplaceNoiseEchartsDetail() {
        List<RecordWorkplaceNoiseResponse> recordWorkplaceNoiseResponseList = this.recordWorkplaceNoiseService.queryNoiseEchartsDetail();
        return new ResponseEntity<>(Result.ok(recordWorkplaceNoiseResponseList), HttpStatus.OK);
    }
}
