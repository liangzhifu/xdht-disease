package com.xdht.disease.third.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by L on 2018/6/12.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/third")
public class ThrirdController {

    @RequestMapping(value = "/testList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试")
    public String getSysThird(@PathVariable  String id){
        return "test" + id;
    }

    @RequestMapping(value = "/testSum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试")
    public Integer sum(@RequestParam Integer num1, @RequestParam Integer number2){
        Integer num = num1 + number2;
        return num;
    }

    @RequestMapping(value = "/testNext", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试")
    public Integer testNext(@RequestBody Integer index) {
        return index + 1;
    }

    @RequestMapping(value = "/testPrv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "测试")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public Integer testPrv(@RequestBody Integer index) {
        return index - 1;
    }
}
