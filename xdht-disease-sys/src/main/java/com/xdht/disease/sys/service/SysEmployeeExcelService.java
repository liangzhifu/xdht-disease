package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.SysEmployeeExcel;

/**
 * @author Created by L on 2019/1/17.
 */
public interface SysEmployeeExcelService extends Service<SysEmployeeExcel> {

    /**
     * 检查数据
     * @throws Exception 异常
     */
    void updateCheckSysEmployeeExcel() throws Exception;

    /**
     * 清空数据表
     */
    void updateClearSysEmployeeExcel();

}
