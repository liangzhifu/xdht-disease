package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysEmployeeExcel;

public interface SysEmployeeExcelMapper extends Mapper<SysEmployeeExcel> {

    void updateCopanyId();

    void updateOfficeId();

    void updateWorkTypeId();

    void updateEmpSex();

    void updateEmpMarriage();

    void updateClearSysEmployeeExcel();

}