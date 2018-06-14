package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;

import java.util.List;

public interface SysEmployeeMapper extends Mapper<SysEmployee> {

    /**
     * 根据单位员工信息
     * @param sysEmployeeCompanyRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployee> selectCompanyEmployeeList(SysEmployeeCompanyRequest sysEmployeeCompanyRequest);

}