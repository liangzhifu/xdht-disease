package com.xdht.disease.sys.controller;

import com.xdht.disease.sys.model.record_employee_summary_excel;
import com.xdht.disease.sys.service.record_employee_summary_excelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by lzf on 2018/08/20.
*/
@RestController
@RequestMapping("/record/employee/summary/excel")
public class record_employee_summary_excelController {
    @Resource
    private record_employee_summary_excelService record_employee_summary_excelService;
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
   public void insert(){
      this.record_employee_summary_excelService.saveRecordEmployeeSummaryExcel();
   }
/*
    @PostMapping("/add")
    public Result add(record_employee_summary_excel record_employee_summary_excel) {
        record_employee_summary_excelService.save(record_employee_summary_excel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        record_employee_summary_excelService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(record_employee_summary_excel record_employee_summary_excel) {
        record_employee_summary_excelService.update(record_employee_summary_excel);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        record_employee_summary_excel record_employee_summary_excel = record_employee_summary_excelService.findById(id);
        return ResultGenerator.genSuccessResult(record_employee_summary_excel);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<record_employee_summary_excel> list = record_employee_summary_excelService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
}
