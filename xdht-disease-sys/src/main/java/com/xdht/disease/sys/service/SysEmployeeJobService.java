package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.vo.request.SysEmployeeJobRequest;

import java.util.List;

public interface SysEmployeeJobService extends Service<SysEmployeeJob> {

    /**
     * 查询员工工作
     * @param sysEmployeeIobRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployeeJob> querySysEmpJobList(SysEmployeeJobRequest sysEmployeeIobRequest);

}
