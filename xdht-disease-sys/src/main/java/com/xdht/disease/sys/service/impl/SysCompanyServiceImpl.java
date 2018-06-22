package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysCompanyServiceImpl extends AbstractService<SysCompany> implements SysCompanyService{

    @Override
    public PageResult<SysCompany> querySysCompanyListPage(SysCompanyRequest sysCompanyRequest) {
        Condition condition = new Condition(SysCompany.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysCompanyRequest.getCompanyName() != null){
            condition.getOredCriteria().get(0).andLike("companyName","%"+sysCompanyRequest.getCompanyName()+"%");
        }
        PageHelper.startPage(sysCompanyRequest.getPageNumber(), sysCompanyRequest.getPageSize());
        List<SysCompany> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysCompany> pageList = new  PageResult<>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public List<SysCompany> querySysCompanyList(SysCompany sysCompany) {
        Condition condition = new Condition(SysCompany.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysCompany.getCompanyName() != null){
            condition.getOredCriteria().get(0).andLike("companyName","%"+sysCompany.getCompanyName()+"%");
        }
        return this.selectByCondition(condition);
    }

    @Override
    public List<SysCompany> querylistAll() {
            return this.selectAll();
        }

    @Override
    public void addCompany(SysCompany sysCompany) {
        sysCompany.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        SysCompany sysCompany = new SysCompany();
        sysCompany.setId(id);
        sysCompany.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysCompany);
    }

    @Override
    public void updateCompany(SysCompany sysCompany) {
        this.updateByPrimaryKeySelective(sysCompany);
    }

}
