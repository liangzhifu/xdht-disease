package com.xdht.disease.test.client;

import com.xdht.disease.common.authorization.annotation.Authorization;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by L on 2018/6/12.
 */
@FeignClient(name = "xdht-disease-third")
public interface ThirdClient {

    @RequestMapping(value = "/api/v1/third/testList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getSysThird(@PathVariable("id") String id);

    @RequestMapping(value = "/api/v1/third/testSum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Integer sum(@RequestParam("num1") Integer num1, @RequestParam("number2") Integer number2);

    @RequestMapping(value = "/api/v1/third/testNext", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Integer testNext(@RequestBody Integer index);

}
