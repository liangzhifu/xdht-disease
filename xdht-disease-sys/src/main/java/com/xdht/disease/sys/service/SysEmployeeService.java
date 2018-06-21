package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
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
    public PageResult<SysEmployee> querySysEmpPage(SysEmployeeRequest sysEmployeeRequest);


    /**
     * 查询员工列表
     * @param sysEmployeeCompanyRequest 查询条件
     * @return 返回结果
     */
    public List<SysEmployee> queryCompanyEmployeeList(SysEmployeeCompanyRequest sysEmployeeCompanyRequest);

    /**
     * 添加员工
     * @param sysEmployeeResponse 员工实体
     * @return 返回结果
     */
    public SysEmployeeResponse addEmployee(SysEmployeeResponse sysEmployeeResponse);

    /**
     * 删除员工
     * @param id 员工id
     * @return 返回结果
     */
    public SysEmployeeResponse deleteEmployee(Long id);

    /**
     * 修改员工
     * @param sysEmployee 员工实体
     * @return 返回结果
     */
    public SysEmployeeResponse updateEmployee(SysEmployeeResponse sysEmployeeResponse);


    SysEmployeeResponse getEmployeeDetail(Long id);
}
