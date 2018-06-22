package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
@Transactional
public class SysEmployeeDiseaseServiceImpl extends AbstractService<SysEmployeeDisease> implements SysEmployeeDiseaseService{

    @Override
    public List<SysEmployeeDisease> querySysEmpDiseaseList(SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest) {
        Condition condition = new Condition(SysEmployeeDisease.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeDiseaseRequest.getEmployeeId())
            .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysEmployeeDiseaseRequest.getDiseaseName() != null) {
            condition.getOredCriteria().get(0).andLike("diseaseName","%"+sysEmployeeDiseaseRequest.getDiseaseName()+"%");
        }
        condition.setOrderByClause("id desc");
        return this.selectByCondition(condition);
    }

}
