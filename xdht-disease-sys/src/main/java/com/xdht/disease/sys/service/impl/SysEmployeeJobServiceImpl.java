package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.service.SysEmployeeJobService;
import com.xdht.disease.sys.vo.request.SysEmployeeJobRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
@Transactional
public class SysEmployeeJobServiceImpl extends AbstractService<SysEmployeeJob> implements SysEmployeeJobService{

    @Override
    public List<SysEmployeeJob> querySysEmpJobList(SysEmployeeJobRequest sysEmployeeIobRequest) {
        Condition condition = new Condition(SysEmployeeJob.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeIobRequest.getEmployeeId())
            .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        if (sysEmployeeIobRequest.getCompanyName() != null) {
            condition.getOredCriteria().get(0).andLike("companyName","%"+sysEmployeeIobRequest.getCompanyName()+"%");
        }
        condition.setOrderByClause("id desc");
        return this.selectByCondition(condition);
    }

}
