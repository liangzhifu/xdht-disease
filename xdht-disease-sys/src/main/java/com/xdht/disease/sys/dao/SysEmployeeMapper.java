package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysEmployee;

import java.util.List;

public interface SysEmployeeMapper extends Mapper<SysEmployee> {
    /**
     * 根据部门id查询员工信息
     * @param officeIds 部门id
     * @return 返回结果
     */
    List<SysEmployee> queryEmployeeList(List<Long> officeIds);
}