package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysEmployeeExcelMapper;
import com.xdht.disease.sys.model.SysEmployeeExcel;
import com.xdht.disease.sys.service.SysEmployeeExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author Created by L on 2019/1/17.
 */
@Service
@Transactional
public class SysEmployeeExcelServiceImpl extends AbstractService<SysEmployeeExcel> implements SysEmployeeExcelService {

    @Autowired
    private SysEmployeeExcelMapper sysEmployeeExcelMapper;

    @Override
    public void updateCheckSysEmployeeExcel() throws Exception {
        String error = "";
        this.sysEmployeeExcelMapper.updateCopanyId();
        Condition condition = new Condition(SysEmployeeExcel.class);
        condition.createCriteria().andIsNull("companyId");
        List<SysEmployeeExcel> sysEmployeeExcelList = this.selectByCondition(condition);
        if (sysEmployeeExcelList != null && !sysEmployeeExcelList.isEmpty()) {
            for (SysEmployeeExcel sysEmployeeExcel: sysEmployeeExcelList) {
                error += sysEmployeeExcel.getCompanyName() + ":";
            }
            error += "公司名称不存在！";
            throw new Exception(error);
        }
        this.sysEmployeeExcelMapper.updateOfficeId();
        condition = new Condition(SysEmployeeExcel.class);
        condition.createCriteria().andIsNull("officeId");
        sysEmployeeExcelList = this.selectByCondition(condition);
        if (sysEmployeeExcelList != null && !sysEmployeeExcelList.isEmpty()) {
            for (SysEmployeeExcel sysEmployeeExcel: sysEmployeeExcelList) {
                error += sysEmployeeExcel.getCompanyName() + "_" + sysEmployeeExcel.getOfficeName() + ":";
            }
            error += "部门名称不存在！";
            throw new Exception(error);
        }
        this.sysEmployeeExcelMapper.updateWorkTypeId();
        condition = new Condition(SysEmployeeExcel.class);
        condition.createCriteria().andIsNull("workTypeId");
        sysEmployeeExcelList = this.selectByCondition(condition);
        if (sysEmployeeExcelList != null && !sysEmployeeExcelList.isEmpty()) {
            for (SysEmployeeExcel sysEmployeeExcel: sysEmployeeExcelList) {
                error += sysEmployeeExcel.getCompanyName() + "_" + sysEmployeeExcel.getOfficeName() + "_" + sysEmployeeExcel.getWorkTypeName() + ":";
            }
            error += "工种不存在！";
            throw new Exception(error);
        }
        this.sysEmployeeExcelMapper.updateEmpSex();
        this.sysEmployeeExcelMapper.updateEmpMarriage();
    }

    @Override
    public void updateClearSysEmployeeExcel() {
        this.sysEmployeeExcelMapper.updateClearSysEmployeeExcel();
    }

}
