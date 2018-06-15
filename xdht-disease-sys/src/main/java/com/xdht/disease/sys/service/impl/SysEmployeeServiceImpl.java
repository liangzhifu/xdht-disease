package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysEmployeeMapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.service.SysEmployeeService;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
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
public class SysEmployeeServiceImpl extends AbstractService<SysEmployee> implements SysEmployeeService{

    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

        @Override
        public PageResult<SysEmployee> querySysEmpPage(SysEmployeeRequest sysEmployeeRequest) {
            Condition condition = new Condition(SysEmployee.class);
            condition.createCriteria()
                    .andEqualTo("officeId", sysEmployeeRequest.getOfficeId())
                    .andEqualTo("empSex",sysEmployeeRequest.getEmpSex())
                    .andEqualTo("empMarriage",sysEmployeeRequest.getEmpMarriage())
                    .andEqualTo("empEducation",sysEmployeeRequest.getEmpEducation());
            if (sysEmployeeRequest.getEmpName() != null) {
                condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployeeRequest.getEmpName()+"%");
            }
            if(sysEmployeeRequest.getEmpNative() != null){
                condition.getOredCriteria().get(0).andLike("empNative",sysEmployeeRequest.getEmpNative());
            }
            PageHelper.startPage(sysEmployeeRequest.getPageNum(), sysEmployeeRequest.getPageSize());
            List<SysEmployee> dataList = this.sysEmployeeMapper.selectByCondition(condition);
            PageResult<SysEmployee> pageList = new PageResult<SysEmployee>();
            pageList.setDataList(dataList);
            pageList.setTotal(dataList.size());
            return pageList;
        }

        @Override
        public List<SysEmployee> querySysEmpList(SysEmployee sysEmployee) {
            Condition condition = new Condition(SysEmployee.class);
            condition.createCriteria()
                    .andEqualTo("officeId", sysEmployee.getOfficeId())
                    .andEqualTo("empSex",sysEmployee.getEmpSex())
                    .andEqualTo("empMarriage",sysEmployee.getEmpMarriage())
                    .andEqualTo("empEducation",sysEmployee.getEmpEducation());
            if (sysEmployee.getEmpName() != null) {
                condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployee.getEmpName()+"%");
            }
            if(sysEmployee.getEmpNative() != null){
                condition.getOredCriteria().get(0).andLike("empNative",sysEmployee.getEmpNative());
            }
            condition.setOrderByClause("id desc");
            List<SysEmployee> sysEmployeeList = this.sysEmployeeMapper.selectByCondition(condition);
            return sysEmployeeList;
        }

    @Override
    public List<SysEmployee> queryCompanyEmployeeList(SysEmployeeCompanyRequest sysEmployeeCompanyRequest) {
        return this.sysEmployeeMapper.selectCompanyEmployeeList(sysEmployeeCompanyRequest);
    }

    @Override
    public SysEmployeeResponse addEmployee(SysEmployee sysEmployee) {
        this.sysEmployeeMapper.insertUseGeneratedKeys(sysEmployee);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(sysEmployee.getId());
        sysEmployeeResponse.setEmpName(sysEmployee.getEmpName());
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse deleteEmployee(Long id) {
        this.sysEmployeeMapper.deleteByPrimaryKey(id);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(id);
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse updateEmployee(SysEmployee sysEmployee) {
        this.sysEmployeeMapper.updateByPrimaryKeySelective(sysEmployee);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(sysEmployee.getId());
        sysEmployeeResponse.setEmpName(sysEmployee.getEmpName());
        return sysEmployeeResponse;
    }



}
