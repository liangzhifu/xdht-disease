package com.xdht.disease.test.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.test.client.ThirdClient;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by L on 2018/6/12.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {

    @Autowired
    private ThirdClient thirdClient;

    @RequestMapping(value = "/testThird", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testThird(@RequestParam String id){
        String value = thirdClient.getSysThird(id);
        System.out.println(value);
        return value;
    }

    @RequestMapping(value = "/testSum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer sum(@RequestParam Integer num1, @RequestParam Integer number2){
        Integer num = thirdClient.sum(num1, number2);
        return num;
    }

    @RequestMapping(value = "/testNext", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer testNext(@RequestBody Integer index) {
        return thirdClient.testNext(index);
    }


}
