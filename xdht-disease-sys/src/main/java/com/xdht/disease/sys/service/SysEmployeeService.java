package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysEmployeeService extends Service<SysEmployee> {

    /**
     * 分页查询员工列表
     * @param sysEmployeeRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysEmployee> querySysEmpPage(SysEmployeeRequest sysEmployeeRequest);


    /**
     * 查询员工列表
     * @param sysEmployeeRequest 查询条件
     * @return 返回结果
     */
    List<SysEmployee> queryCompanyEmployeeList(SysEmployeeRequest sysEmployeeRequest);

    /**
     * 添加员工
     * @param sysEmployeeResponse 员工实体
     */
    void addEmployee(SysEmployeeResponse sysEmployeeResponse) throws Exception ;

    /**
     * 删除员工
     * @param id 员工id
     */
    void deleteEmployee(Long id);

    /**
     * 修改员工
     * @param sysEmployeeResponse 员工实体
     */
    void updateEmployee(SysEmployeeResponse sysEmployeeResponse);


    SysEmployeeResponse getEmployeeDetail(Long id);
}
