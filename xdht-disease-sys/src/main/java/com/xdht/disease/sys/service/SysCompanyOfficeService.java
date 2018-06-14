package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.vo.request.SysCompanyOfficeRequest;
import com.xdht.disease.sys.vo.response.SysCompanyOfficeResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysCompanyOfficeService extends Service<SysCompanyOffice> {

    /**
     * 分页查询单位部门
     * @param sysCompanyOfficeRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysCompanyOffice> querySysCompanyOfficePage(SysCompanyOfficeRequest sysCompanyOfficeRequest);

    /**
     * 查询公司列表
     * @param sysCompanyOffice 查询条件
     * @return 返回结果
     */
    public List<SysCompanyOffice> querySysCompanyOfficeList(SysCompanyOffice sysCompanyOffice);
    /**
     * 添加单位部门
     * @param sysCompanyOffice 单位部门实体
     * @return 返回结果
     */
    public SysCompanyOfficeResponse addCompanyOffice(SysCompanyOffice sysCompanyOffice);

    /**
     * 删除单位部门
     * @param id 单位部门id
     * @return 返回结果
     */
    public SysCompanyOfficeResponse deleteCompanyOffice(Long id);

    /**
     * 修改单位部门
     * @param sysCompanyOffice 单位部门实体
     * @return 返回结果
     */
    public SysCompanyOfficeResponse updateCompanyOffice(SysCompanyOffice sysCompanyOffice);

    /**
     * 根据部门查询员工列表
     * @param sysCompanyOffice 查询条件
     * @return 返回结果
     */
    public List<SysEmployee> queryEmpleoyeeList(SysCompanyOffice sysCompanyOffice);
}
