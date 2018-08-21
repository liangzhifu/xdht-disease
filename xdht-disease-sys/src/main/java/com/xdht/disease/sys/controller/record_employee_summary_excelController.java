package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.constant.ResultCode;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.record_employee_summary_excel;
import com.xdht.disease.sys.service.record_employee_summary_excelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lzf on 2018/08/20.
*/
@RestController
@RequestMapping("/api/v1/summaryExcel")
public class record_employee_summary_excelController {
    @Resource
    private record_employee_summary_excelService record_employee_summary_excelService;
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
   public void insert(){
      this.record_employee_summary_excelService.saveRecordEmployeeSummaryExcel();
   }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ApiOperation(value = "个人体检Excel上传")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> upload(@RequestParam("uploadFile") MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        try {
            //FileUtil.uploadFile(file.getBytes(), fileName);
        } catch (Exception e) {
            return new ResponseEntity<>(Result.error(ResultCode.FAIL, e.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }
}
