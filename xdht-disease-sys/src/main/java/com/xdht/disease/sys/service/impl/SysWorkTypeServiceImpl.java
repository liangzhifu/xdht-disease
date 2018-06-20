package com.xdht.disease.sys.service.impl;

import com.xdht.disease.sys.dao.SysWorkTypeMapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysWorkType;
import com.xdht.disease.sys.service.SysWorkTypeService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysWorkTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lzf on 2018/06/20.
 */
@Service
@Transactional
public class SysWorkTypeServiceImpl extends AbstractService<SysWorkType> implements SysWorkTypeService {

    @Autowired
    private SysWorkTypeMapper sysWorkTypeMapper;

    @Override
    public List<SysWorkType> querySysWorkTypeList(SysWorkTypeRequest sysWorkTypeRequest) {
        Condition condition = new Condition(SysWorkType.class);
        condition.createCriteria().andEqualTo("name",sysWorkTypeRequest.getName());
        return sysWorkTypeMapper.selectByCondition(condition);
    }
}
