package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysEmployeeCaseMapper;
import com.xdht.disease.sys.dao.SysEmployeeDiseaseMapper;
import com.xdht.disease.sys.dao.SysEmployeeJobMapper;
import com.xdht.disease.sys.dao.SysEmployeeMapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.service.SysEmployeeJobService;
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
    @Autowired
    private SysEmployeeCaseMapper sysEmployeeCaseMapper;
    @Autowired
    private SysEmployeeDiseaseMapper sysEmployeeDiseaseMapper;
    @Autowired
    private SysEmployeeJobMapper sysEmployeeJobMapper;
    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;
    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;
    @Autowired
    private SysEmployeeJobService sysEmployeeJobService;

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
            PageHelper.startPage(sysEmployeeRequest.getPageNumber(), sysEmployeeRequest.getPageSize());
            List<SysEmployee> dataList = this.sysEmployeeMapper.selectByCondition(condition);
            PageResult<SysEmployee> pageList = new PageResult<SysEmployee>();
            pageList.setDataList(dataList);
            pageList.setTotal(dataList.size());
            return pageList;
        }

        @Override
        public List<SysEmployee> queryCompanyEmployeeList(SysEmployeeCompanyRequest sysEmployeeCompanyRequest) {
            Condition condition = new Condition(SysEmployee.class);
            condition.createCriteria()
                    .andEqualTo("officeId", sysEmployeeCompanyRequest.getCompanyOfficeId());
            if (sysEmployeeCompanyRequest.getEmpName() != null) {
                condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployeeCompanyRequest.getEmpName()+"%");
            }
            if(sysEmployeeCompanyRequest.getEmpNative() != null){
                condition.getOredCriteria().get(0).andLike("empNative",sysEmployeeCompanyRequest.getEmpNative());
            }
            condition.setOrderByClause("id desc");
            List<SysEmployee> sysEmployeeList = this.sysEmployeeMapper.selectByCondition(condition);
            return sysEmployeeList;
        }

    @Override
    public SysEmployeeResponse addEmployee(SysEmployeeResponse sysEmployeeResponse) {
        //
        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysEmployee);
        //
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
            sysEmployeeCase.setEmployeeId(sysEmployee.getId());
            sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        sysEmployeeCaseService.insertList(sysEmployeeCaseList);
        //
        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
            sysEmployeeDisease.setEmployeeId(sysEmployee.getId());
            sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        sysEmployeeDiseaseService.insertList(sysEmployeeDiseaseList);
        //
        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
            sysEmployeeJob.setEmployeeId(sysEmployee.getId());
            sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        sysEmployeeJobService.insertList(sysEmployeeJobList);
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse deleteEmployee(Long id) {
        SysEmployeeResponse employeeDetail = getEmployeeDetail(id);


        SysEmployee sysEmployee = employeeDetail.getSysEmployee();
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.sysEmployeeMapper.updateByPrimaryKey(sysEmployee);

        List<SysEmployeeCase> sysEmployeeCases = employeeDetail.getSysEmployeeCaseList();
        for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
            sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeCaseMapper.updateByPrimaryKey(sysEmployeeCase);
        }
        //
        List<SysEmployeeDisease> sysEmployeeDiseases = employeeDetail.getSysEmployeeDiseaseList();
        for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
            sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeDiseaseMapper.updateByPrimaryKey(sysEmployeeDisease);
        }
        //
        List<SysEmployeeJob> sysEmployeeJobs = employeeDetail.getSysEmployeeJobList();
        for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
            sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeJobMapper.updateByPrimaryKey(sysEmployeeJob);
        }
        //
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setSysEmployee(sysEmployee);
        return sysEmployeeResponse;
    }

    /**
     * 修改
     * @param sysEmployeeResponse
     * @return
     */
    @Override
    public SysEmployeeResponse updateEmployee(SysEmployeeResponse sysEmployeeResponse) {
        //
        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        Long sysEmployeeId = sysEmployee.getId();
        this.sysEmployeeMapper.updateByPrimaryKeySelective(sysEmployee);
        //
        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeId);
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseMapper.selectByCondition(condition);
        for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
            sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeCaseMapper.updateByPrimaryKey(sysEmployeeCase);
        }
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
            sysEmployeeCase.setEmployeeId(sysEmployeeId);
            sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        this.sysEmployeeCaseMapper.insertList(sysEmployeeCaseList);
        //
        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", sysEmployeeId);
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseMapper.selectByCondition(condition1);
        for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
            sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeDiseaseMapper.updateByPrimaryKey(sysEmployeeDisease);
        }
        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
            sysEmployeeDisease.setEmployeeId(sysEmployeeId);
            sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        this.sysEmployeeDiseaseMapper.insertList(sysEmployeeDiseaseList);
        //
        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", sysEmployeeId);
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobMapper.selectByCondition(condition1);
        for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
            sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
            this.sysEmployeeJobMapper.updateByPrimaryKey(sysEmployeeJob);
        }
        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
            sysEmployeeJob.setEmployeeId(sysEmployeeId);
            sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        }
        this.sysEmployeeJobMapper.insertList(sysEmployeeJobList);
        //
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse getEmployeeDetail(Long id) {
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        SysEmployee sysEmployee = this.sysEmployeeMapper.selectByPrimaryKey(id);
        sysEmployeeResponse.setSysEmployee(sysEmployee);
        //
        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseMapper.selectByCondition(condition);
        sysEmployeeResponse.setSysEmployeeCaseList(sysEmployeeCases);
        //
        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseMapper.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeDiseaseList(sysEmployeeDiseases);
        //
        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobMapper.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeJobList(sysEmployeeJobs);
        return sysEmployeeResponse;
    }


}
