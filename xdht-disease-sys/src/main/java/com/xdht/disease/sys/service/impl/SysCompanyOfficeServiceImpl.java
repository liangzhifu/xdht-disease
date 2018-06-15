package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysCompanyOfficeMapper;
import com.xdht.disease.sys.dao.SysEmployeeMapper;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.SysCompanyOfficeRequest;
import com.xdht.disease.sys.vo.response.SysCompanyOfficeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysCompanyOfficeServiceImpl extends AbstractService<SysCompanyOffice> implements SysCompanyOfficeService{

    @Autowired
    private SysCompanyOfficeMapper sysCompanyOfficeMapper;

        @Override
        public PageResult<SysCompanyOffice> querySysCompanyOfficePage(SysCompanyOfficeRequest sysCompanyOfficeRequest) {
            Condition condition = new Condition(SysCompanyOffice.class);
            condition.createCriteria() .andEqualTo("companyId", sysCompanyOfficeRequest.getCompanyId());
            if (sysCompanyOfficeRequest.getOfficeName() != null) {
                condition.getOredCriteria().get(0).andLike("officeName","%"+sysCompanyOfficeRequest.getOfficeName()+"%");
            }
            PageHelper.startPage(sysCompanyOfficeRequest.getPageNum(), sysCompanyOfficeRequest.getPageSize());
            List<SysCompanyOffice> dataList = this.sysCompanyOfficeMapper.selectByCondition(condition);
            PageResult<SysCompanyOffice> pageList = new  PageResult<SysCompanyOffice>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public List<SysCompanyOffice> querySysCompanyOfficeList(SysCompanyOffice sysCompanyOffice) {
            Condition condition = new Condition(SysCompanyOffice.class);
            condition.createCriteria() .andEqualTo("companyId", sysCompanyOffice.getCompanyId());
            if (sysCompanyOffice.getOfficeName() != null) {
                condition.getOredCriteria().get(0).andLike("officeName","%"+sysCompanyOffice.getOfficeName()+"%");
            }
            List<SysCompanyOffice> sysCompanyOfficeList = this.sysCompanyOfficeMapper.selectByCondition(condition);
            return sysCompanyOfficeList;
        }

        @Override
        public SysCompanyOfficeResponse addCompanyOffice(SysCompanyOffice sysCompanyOffice) {
            this.sysCompanyOfficeMapper.insertUseGeneratedKeys(sysCompanyOffice);
            SysCompanyOfficeResponse sysCompanyOfficeResponse = new SysCompanyOfficeResponse();
            sysCompanyOfficeResponse.setId(sysCompanyOffice.getId());
            sysCompanyOfficeResponse.setOfficeName(sysCompanyOffice.getOfficeName());
            return sysCompanyOfficeResponse;
        }

        @Override
        public SysCompanyOfficeResponse deleteCompanyOffice(Long id) {
            this.sysCompanyOfficeMapper.deleteByPrimaryKey(id);
            SysCompanyOfficeResponse sysCompanyOfficeResponse = new SysCompanyOfficeResponse();
            sysCompanyOfficeResponse.setId(id);
            return sysCompanyOfficeResponse;
        }

        @Override
        public SysCompanyOfficeResponse updateCompanyOffice(SysCompanyOffice sysCompanyOffice) {
            this.sysCompanyOfficeMapper.updateByPrimaryKeySelective(sysCompanyOffice);
            SysCompanyOfficeResponse sysCompanyOfficeResponse = new SysCompanyOfficeResponse();
            sysCompanyOfficeResponse.setId(sysCompanyOffice.getId());
            sysCompanyOfficeResponse.setOfficeName(sysCompanyOffice.getOfficeName());
            return sysCompanyOfficeResponse;
        }

}
