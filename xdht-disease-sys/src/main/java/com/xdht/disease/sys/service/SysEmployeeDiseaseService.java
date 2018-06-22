package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysEmployeeDiseaseService extends Service<SysEmployeeDisease> {

    /**
     * 查询员工职业病
     * @param sysEmployeeDiseaseRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployeeDisease> querySysEmpDiseaseList(SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest);

}
