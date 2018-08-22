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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
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

       /* this.record_employee_summary_excelService.saveRecordEmployeeSummaryExcel();*/
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
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);

            }
        } catch (IOException e) {

        }

        try {
            this.record_employee_summary_excelService.saveRecordEmployeeSummaryExcel(workbook);
            //FileUtil.uploadFile(file.getBytes(), fileName);
        } catch (Exception e) {
            return new ResponseEntity<>(Result.error(ResultCode.FAIL, e.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }
}
