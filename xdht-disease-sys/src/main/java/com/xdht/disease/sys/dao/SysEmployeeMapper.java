package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;

import java.util.List;
import java.util.Map;

public interface SysEmployeeMapper extends Mapper<SysEmployee> {

    /**
     * 根据单位员工信息
     * @param sysEmployeeCompanyRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployee> selectCompanyEmployeeList(SysEmployeeCompanyRequest sysEmployeeCompanyRequest);

    /**
     * 根据查询条件查询职工列表
     * @param sysEmployeeRequest 查询条件
     * @return 返回结果
     */
    List<Map<String, Object>> selectCompanyEmployeeListByRequest(SysEmployeeRequest sysEmployeeRequest);

    /**
     * 根据查询条件查询职工树立
     * @param sysEmployeeRequest 查询条件
     * @return 返回结果
     */
    Integer selectCompanyEmployeeCountByRequest(SysEmployeeRequest sysEmployeeRequest);
}