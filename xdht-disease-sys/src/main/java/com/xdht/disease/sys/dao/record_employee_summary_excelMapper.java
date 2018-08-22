package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.record_employee_summary_excel;

public interface record_employee_summary_excelMapper extends Mapper<record_employee_summary_excel> {
    /*
    根据公司名称 查找公司的 ID
    */

    void updateExcelCompanyId();



    /*
    根据 岗位名称 查找岗位ID
    */

    void updateExcelPostId();

    /*

  根据 工种名称 查找工种ID
  */

    void updateExcelWorkTypeId();
    /*

     批量插入所有excel表到 record_employee_summary

    */
    void insertExcelToRecordEmployeeSummary();

    /*

    查询身份证号判断是否在为员工
     */
     Integer selectIdentity();
     /*
     * 删除全部
     * */
     void deleteAll();

}