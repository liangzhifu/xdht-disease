package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
@Transactional
public class SysEmployeeCaseServiceImpl extends AbstractService<SysEmployeeCase> implements SysEmployeeCaseService{

    @Override
    public List<SysEmployeeCase>  querySysEmpCaseList(SysEmployeeCaseRequest sysEmployeeCaseRequest) {
        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeCaseRequest.getEmployeeId())
            .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysEmployeeCaseRequest.getCaseName() != null) {
            condition.getOredCriteria().get(0).andLike("caseName","%"+sysEmployeeCaseRequest.getCaseName()+"%");
        }
        return this.selectByCondition(condition);
    }

}

