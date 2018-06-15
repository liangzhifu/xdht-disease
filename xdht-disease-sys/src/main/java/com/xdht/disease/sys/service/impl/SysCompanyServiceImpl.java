package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysCompanyMapper;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
import com.xdht.disease.sys.vo.response.SysCompanyResponse;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysCompanyMapper sysCompanyMapper;

        @Override
        public PageResult<SysCompany> querySysCompanyListPage(SysCompanyRequest sysCompanyRequest) {
            Condition condition = new Condition(SysCompany.class);
            if (sysCompanyRequest.getCompanyName() != null){
                condition.createCriteria().andLike("companyName","%"+sysCompanyRequest.getCompanyName()+"%");
            }
            PageHelper.startPage(sysCompanyRequest.getPageNumber(), sysCompanyRequest.getPageSize());
            List<SysCompany> dataList = this.sysCompanyMapper.selectByCondition(condition);
            PageResult<SysCompany> pageList = new  PageResult<SysCompany>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public List<SysCompany> querySysCompanyList(SysCompany sysCompany) {
            Condition condition = new Condition(SysCompany.class);
            if (sysCompany.getCompanyName() != null){
                condition.createCriteria().andLike("companyName","%"+sysCompany.getCompanyName()+"%");
            }
            List<SysCompany> sysCompanyList = this.selectByCondition(condition);
            return sysCompanyList;
        }

        @Override
        public List<SysCompany> querylistAll() {
            return this.selectAll();
        }

        @Override
        public SysCompanyResponse addCompany(SysCompany sysCompany) {
            sysCompany.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            this.insertUseGeneratedKeys(sysCompany);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(sysCompany.getId());
            sysCompanyResponse.setCompanyName(sysCompany.getCompanyName());
            return sysCompanyResponse;
        }

        @Override
        public SysCompanyResponse deleteCompany(Long id) {
            SysCompany company = this.sysCompanyMapper.selectByPrimaryKey(id);
            company.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.updateByPrimaryKeySelective(company);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(id);
            return sysCompanyResponse;
        }

        @Override
        public SysCompanyResponse updateCompany(SysCompany sysCompany) {
            this.sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(sysCompany.getId());
            sysCompanyResponse.setCompanyName(sysCompany.getCompanyName());
            return sysCompanyResponse;
        }

        @Override
        public SysCompany getCompanyDetail(Long id) {

            return this.sysCompanyMapper.selectByPrimaryKey(id);
        }



}
