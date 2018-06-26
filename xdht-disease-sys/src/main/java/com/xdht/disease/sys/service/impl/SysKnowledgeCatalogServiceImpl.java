package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.ThreadLocalUserService;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysKnowledgeCatalogMapper;
import com.xdht.disease.sys.model.SysKnowledgeCatalog;
import com.xdht.disease.sys.service.SysKnowledgeCatalogService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysKnowledgeCatalogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/26.
 */
@Service
@Transactional
public class SysKnowledgeCatalogServiceImpl extends AbstractService<SysKnowledgeCatalog> implements SysKnowledgeCatalogService {

    @Autowired
    private SysKnowledgeCatalogMapper sysKnowledgeCatalogMapper;

    @Autowired
    private ThreadLocalUserService threadLocalUserService;

    @Override
    public List<SysKnowledgeCatalog> querySysKnowledgeCatalogList(SysKnowledgeCatalogRequest sysKnowledgeCatalogRequest) {
        Condition condition = new Condition(SysKnowledgeCatalog.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }

    @Override
    public void addKnowledgeCatalog(SysKnowledgeCatalog sysKnowledgeCatalog) {
        Long parentId = sysKnowledgeCatalog.getParentId();
        if (parentId == 0){
            sysKnowledgeCatalog.setParentIds(",0,");
        } else {
            SysKnowledgeCatalog sysKnowledgeCatalogTemp = this.selectByPrimaryKey(parentId);
            sysKnowledgeCatalog.setParentIds(sysKnowledgeCatalogTemp.getParentIds() + parentId + ",");
        }
        sysKnowledgeCatalog.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysKnowledgeCatalog);
    }

    @Override
    public void deleteKnowledgeCatalog(Long id) {
        SysKnowledgeCatalog sysKnowledgeCatalog = new SysKnowledgeCatalog();
        sysKnowledgeCatalog.setId(id);
        sysKnowledgeCatalog.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", threadLocalUserService.getUser().getId());
        this.sysKnowledgeCatalogMapper.deleteChild(map);
        this.updateByPrimaryKeySelective(sysKnowledgeCatalog);
    }

    @Override
    public void updateKnowledgeCatalog(SysKnowledgeCatalog sysKnowledgeCatalog) {
        this.updateByPrimaryKeySelective(sysKnowledgeCatalog);
    }
}
