package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysCompanyService extends Service<SysCompany> {

    /**
     * 分页查询单位列表
     * @param sysCompanyRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysCompany> querySysCompanyListPage(SysCompanyRequest sysCompanyRequest);

    /**
     * 添加单位
     * @param sysCompany 单位实体
     * @return 返回结果
     */
    void addCompany(SysCompany sysCompany);

    /**
     * 删除单位
     * @param id 单位id
     * @return 返回结果
     */
    void deleteCompany(Long id);

    /**
     * 修改单位
     * @param sysCompany 单位实体
     * @return 返回结果
     */
    void updateCompany(SysCompany sysCompany);

    /**
     * 公司列表查询
     * @param sysCompany 查询条件
     * @return 返回结果
     */
    List<SysCompany> querySysCompanyList(SysCompany sysCompany);

    /**
     * 查询所有列表
     * @return 返回结果
     */
    List<SysCompany> querylistAll();

}
