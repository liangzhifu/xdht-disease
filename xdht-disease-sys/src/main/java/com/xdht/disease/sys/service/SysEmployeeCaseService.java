package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;

import java.util.List;


public interface SysEmployeeCaseService extends Service<SysEmployeeCase> {

    /**
     * 查询员工疾病列表
     * @param sysEmployeeCaseRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployeeCase> querySysEmpCaseList(SysEmployeeCaseRequest sysEmployeeCaseRequest);

}
