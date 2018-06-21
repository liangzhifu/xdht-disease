package com.xdht.disease.sys.service;

import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysCompanyOfficeRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysCompanyOfficeService extends Service<SysCompanyOffice> {

    /**
     * 查询公司列表
     * @param sysCompanyOfficeRequest 查询条件
     * @return 返回结果
     */
    List<SysCompanyOffice> querySysCompanyOfficeList(SysCompanyOfficeRequest sysCompanyOfficeRequest);

    /**
     * 添加单位部门
     * @param sysCompanyOffice 单位部门实体
     */
    void addCompanyOffice(SysCompanyOffice sysCompanyOffice);

    /**
     * 删除单位部门
     * @param id 单位部门id
     */
    void deleteCompanyOffice(Long id);

    /**
     * 修改单位部门
     * @param sysCompanyOffice 单位部门实体
     */
    void updateCompanyOffice(SysCompanyOffice sysCompanyOffice);

}
