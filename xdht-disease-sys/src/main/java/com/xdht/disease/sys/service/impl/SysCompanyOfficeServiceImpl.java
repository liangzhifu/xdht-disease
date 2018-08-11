package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysCompanyOfficeMapper;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.SysCompanyOfficeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysCompanyOfficeServiceImpl extends AbstractService<SysCompanyOffice> implements SysCompanyOfficeService {

    @Autowired
    private SysCompanyOfficeMapper sysCompanyOfficeMapper;

    @Autowired
    private ThreadLocalUserService threadLocalUserService;

    @Override
    public List<SysCompanyOffice> querySysCompanyOfficeList(SysCompanyOfficeRequest sysCompanyOfficeRequest) {
        Condition condition = new Condition(SysCompanyOffice.class);
        condition.createCriteria() .andEqualTo("companyId", sysCompanyOfficeRequest.getCompanyId())
                .andEqualTo("officeType", sysCompanyOfficeRequest.getOfficeType())
                .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }

    @Override
    public void addCompanyOffice(SysCompanyOffice sysCompanyOffice) {
        Long parentId = sysCompanyOffice.getParentId();
        if (parentId == 0) {
            sysCompanyOffice.setParentIds(",0,");
        } else {
            SysCompanyOffice sysCompanyOfficeTemp = this.selectByPrimaryKey(parentId);
            sysCompanyOffice.setParentIds(sysCompanyOfficeTemp.getParentIds() + parentId + ",");
        }
        sysCompanyOffice.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysCompanyOffice);
    }

    @Override
    public void deleteCompanyOffice(Long id) {
        SysCompanyOffice sysCompanyOffice = this.selectByPrimaryKey(id);
        sysCompanyOffice.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", threadLocalUserService.getUser().getId());
        this.sysCompanyOfficeMapper.deleteChild(map);
        this.updateByPrimaryKeySelective(sysCompanyOffice);
    }

    @Override
    public void updateCompanyOffice(SysCompanyOffice sysCompanyOffice) {
        this.updateByPrimaryKeySelective(sysCompanyOffice);
    }

}
