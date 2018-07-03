package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.util.Md5Utils;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.*;
import com.xdht.disease.sys.service.*;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysEmployeeServiceImpl extends AbstractService<SysEmployee> implements SysEmployeeService{

    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;
    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;
    @Autowired
    private SysEmployeeJobService sysEmployeeJobService;
    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public PageResult<SysEmployee> querySysEmpPage(SysEmployeeRequest sysEmployeeRequest) {
        Condition condition = new Condition(SysEmployee.class);
        condition.createCriteria().andEqualTo("officeId", sysEmployeeRequest.getOfficeId())
            .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysEmployeeRequest.getCompanyId() != null) {
            Condition sysOfficeCondition = new Condition(SysCompanyOffice.class);
            sysOfficeCondition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                    .andEqualTo("companyId", sysEmployeeRequest.getCompanyId());
            List<SysCompanyOffice> sysCompanyOfficeList = this.sysCompanyOfficeService.selectByCondition(sysOfficeCondition);
            List<Long> sysOfficeIdList = new LinkedList<>();
            for (SysCompanyOffice sysCompanyOffice : sysCompanyOfficeList) {
                sysOfficeIdList.add(sysCompanyOffice.getId());
            }
            condition.getOredCriteria().get(0).andIn("officeId", sysOfficeIdList);
        }
        if (sysEmployeeRequest.getEmpName() != null && !"".equals(sysEmployeeRequest.getEmpName())) {
            condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployeeRequest.getEmpName()+"%");
        }
        if (sysEmployeeRequest.getEmpIdentityNumber() != null && !"".equals(sysEmployeeRequest.getEmpIdentityNumber())) {
            condition.getOredCriteria().get(0).andLike("empIdentityNumber","%"+sysEmployeeRequest.getEmpIdentityNumber()+"%");
        }
        if (sysEmployeeRequest.getEmpSex() != null && !"".equals(sysEmployeeRequest.getEmpSex())) {
            condition.getOredCriteria().get(0).andEqualTo("empSex",sysEmployeeRequest.getEmpSex());
        }
        if(sysEmployeeRequest.getEmpNative() != null && !"".equals(sysEmployeeRequest.getEmpNative())){
            condition.getOredCriteria().get(0).andLike("empNative","%" + sysEmployeeRequest.getEmpNative() + "%");
        }
        if(sysEmployeeRequest.getEmpMarriage() != null && !"".equals(sysEmployeeRequest.getEmpMarriage())){
            condition.getOredCriteria().get(0).andEqualTo("empMarriage",sysEmployeeRequest.getEmpMarriage());
        }
        PageHelper.startPage(sysEmployeeRequest.getPageNumber(), sysEmployeeRequest.getPageSize());
        List<SysEmployee> dataList = this.selectByCondition(condition);
        Integer total = this.selectCountByCondition(condition);
        PageResult<SysEmployee> pageList = new PageResult<SysEmployee>();
        pageList.setDataList(dataList);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public List<SysEmployee> queryCompanyEmployeeList(SysEmployeeRequest sysEmployeeRequest) {
        Condition condition = new Condition(SysEmployee.class);
        condition.createCriteria().andEqualTo("officeId", sysEmployeeRequest.getOfficeId());
        if (sysEmployeeRequest.getEmpName() != null && !"".equals(sysEmployeeRequest.getEmpName())) {
            condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployeeRequest.getEmpName()+"%");
        }
        if(sysEmployeeRequest.getEmpNative() != null && !"".equals(sysEmployeeRequest.getEmpNative())){
            condition.getOredCriteria().get(0).andLike("empNative",sysEmployeeRequest.getEmpNative());
        }
        condition.setOrderByClause("id desc");
        return this.selectByCondition(condition);
    }

    @Override
    public void addEmployee(SysEmployeeResponse sysEmployeeResponse) {
        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysEmployee);
        // 同时添加数据到用户表中
        SysUser sysUser = new SysUser();
        sysUser.setUserName(sysEmployee.getEmpName());
        sysUser.setSex(sysEmployee.getEmpSex());
        sysUser.setMgrType(SysEnum.MgrTypeEnum.MGR_TYPE_NOT.getCode());
        sysUser.setLoginCode(sysEmployee.getEmpIdentityNumber());
        sysUser.setPassword(Md5Utils.md5("111111"));
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        sysUser.setEmpId(sysEmployee.getId());
        sysUser.setAvatar(sysEmployee.getImageName());
        this.sysUserService.insertUseGeneratedKeys(sysUser);
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        if (sysEmployeeCaseList != null && sysEmployeeCaseList.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
                sysEmployeeCase.setEmployeeId(sysEmployee.getId());
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeCaseService.insertList(sysEmployeeCaseList);
        }

        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseaseList != null && sysEmployeeDiseaseList.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
                sysEmployeeDisease.setEmployeeId(sysEmployee.getId());
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeDiseaseService.insertList(sysEmployeeDiseaseList);
        }

        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        if (sysEmployeeJobList != null && sysEmployeeJobList.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
                sysEmployeeJob.setEmployeeId(sysEmployee.getId());
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeJobService.insertList(sysEmployeeJobList);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        SysEmployeeResponse employeeDetail = getEmployeeDetail(id);
        SysEmployee sysEmployee = employeeDetail.getSysEmployee();
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysEmployee);
        // 删除用户中关联的职工信息
        Long empId = sysEmployee.getId();
        SysUser sysUser = new SysUser();
        sysUser.setEmpId(empId);
        sysUser = this.sysUserService.selectOne(sysUser);
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.sysUserService.updateByPrimaryKeySelective(sysUser);

        List<SysEmployeeCase> sysEmployeeCases = employeeDetail.getSysEmployeeCaseList();
        if (sysEmployeeCases != null && sysEmployeeCases.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeCaseService.updateByPrimaryKeySelective(sysEmployeeCase);
            }
        }

        List<SysEmployeeDisease> sysEmployeeDiseases = employeeDetail.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseases != null && sysEmployeeDiseases.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeDiseaseService.updateByPrimaryKeySelective(sysEmployeeDisease);
            }
        }

        List<SysEmployeeJob> sysEmployeeJobs = employeeDetail.getSysEmployeeJobList();
        if (sysEmployeeJobs != null && sysEmployeeJobs.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeJobService.updateByPrimaryKeySelective(sysEmployeeJob);
            }
        }


    }

    /**
     * 修改
     * @param sysEmployeeResponse
     */
    @Override
    public void updateEmployee(SysEmployeeResponse sysEmployeeResponse) {

        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        Long sysEmployeeId = sysEmployee.getId();
        this.updateByPrimaryKeySelective(sysEmployee);
        // sysEmployeeId是user表中对应的职工关联id
        // 修改user表对应的职工信息
        SysUser sysUser = new SysUser();
        sysUser.setEmpId(sysEmployeeId);
        sysUser = this.sysUserService.selectOne(sysUser);
        if (sysUser != null) {
            sysUser.setUserName(sysEmployee.getEmpName());
            sysUser.setSex(sysEmployee.getEmpSex());
            sysUser.setLoginCode(sysEmployee.getEmpIdentityNumber());
            sysUser.setAvatar(sysEmployee.getImageName());
            this.sysUserService.updateByPrimaryKeySelective(sysUser);
        }

        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseService.selectByCondition(condition);
        if (sysEmployeeCases != null && sysEmployeeCases.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeCaseService.updateByPrimaryKeySelective(sysEmployeeCase);
            }
        }
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        if (sysEmployeeCaseList != null && sysEmployeeCaseList.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
                sysEmployeeCase.setEmployeeId(sysEmployeeId);
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeCaseService.insertList(sysEmployeeCaseList);
        }

        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseService.selectByCondition(condition1);
        if (sysEmployeeDiseases != null && sysEmployeeDiseases.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeDiseaseService.updateByPrimaryKeySelective(sysEmployeeDisease);
            }
        }
        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseaseList != null && sysEmployeeDiseaseList.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
                sysEmployeeDisease.setEmployeeId(sysEmployeeId);
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeDiseaseService.insertList(sysEmployeeDiseaseList);
        }

        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobService.selectByCondition(condition1);
        if (sysEmployeeJobs != null && sysEmployeeJobs.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeJobService.updateByPrimaryKeySelective(sysEmployeeJob);
            }
        }
        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        if (sysEmployeeJobList != null && sysEmployeeJobList.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
                sysEmployeeJob.setEmployeeId(sysEmployeeId);
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeJobService.insertList(sysEmployeeJobList);
        }
    }

    @Override
    public SysEmployeeResponse getEmployeeDetail(Long id) {
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        SysEmployee sysEmployee = this.selectByPrimaryKey(id);
        Long officeId = sysEmployee.getOfficeId();
        SysCompanyOffice sysCompanyOffice = new SysCompanyOffice();
        if (officeId != null) {
            sysCompanyOffice = this.sysCompanyOfficeService.selectByPrimaryKey(officeId);
            sysEmployeeResponse.setSysCompanyOffice(sysCompanyOffice);
        }else{
            sysEmployeeResponse.setSysCompanyOffice(sysCompanyOffice);
        }
        sysEmployeeResponse.setSysEmployee(sysEmployee);

        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseService.selectByCondition(condition);
        sysEmployeeResponse.setSysEmployeeCaseList(sysEmployeeCases);

        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseService.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeDiseaseList(sysEmployeeDiseases);

        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", id).andEqualTo("status",SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobService.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeJobList(sysEmployeeJobs);
        return sysEmployeeResponse;
    }


}
