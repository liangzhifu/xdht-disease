package com.xdht.disease.sys.service.impl;

import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysRoleKnowledgeCatalog;
import com.xdht.disease.sys.service.SysRoleKnowledgeCatalogService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogQueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/26.
 */
@Service
@Transactional
public class SysRoleKnowledgeCatalogServiceImpl extends AbstractService<SysRoleKnowledgeCatalog> implements SysRoleKnowledgeCatalogService {

    @Override
    public List<SysRoleKnowledgeCatalog> querySysRoleKnowledgeCatalogList(SysRoleKnowledgeCatalogQueryRequest sysRoleKnowledgeCatalogQueryRequest) {
        Condition condition = new Condition(SysRoleKnowledgeCatalog.class);
        condition.createCriteria().andEqualTo("roleId", sysRoleKnowledgeCatalogQueryRequest.getRoleId())
                .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        return this.selectByCondition(condition);
    }

    @Override
    public void updateRoleKnowledgeCatalog(SysRoleKnowledgeCatalogEditRequest sysRoleKnowledgeCatalogEditRequest) {
        //删除旧的关联关系
        Long roleId = sysRoleKnowledgeCatalogEditRequest.getRoleId();
        Condition condition = new Condition(SysRoleKnowledgeCatalog.class);
        condition.createCriteria().andEqualTo("roleId", roleId);
        List<SysRoleKnowledgeCatalog> sysRoleKnowledgeCatalogList = this.selectByCondition(condition);
        if (sysRoleKnowledgeCatalogList != null && sysRoleKnowledgeCatalogList.size() > 0) {
            for (SysRoleKnowledgeCatalog sysRoleKnowledgeCatalog : sysRoleKnowledgeCatalogList){
                SysRoleKnowledgeCatalog sysRoleKnowledgeCatalogTemp = new SysRoleKnowledgeCatalog();
                sysRoleKnowledgeCatalogTemp.setId(sysRoleKnowledgeCatalog.getId());
                sysRoleKnowledgeCatalogTemp.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.updateByPrimaryKeySelective(sysRoleKnowledgeCatalogTemp);
            }
        }
        //新增新的关联关系
        String knowledgeCatalogIds = sysRoleKnowledgeCatalogEditRequest.getKnowledgeCatalogIds();
        sysRoleKnowledgeCatalogList = new LinkedList<>();
        if (knowledgeCatalogIds != null && !"".equals(knowledgeCatalogIds)) {
            String[] knowledgeCatalogIdArray = knowledgeCatalogIds.split(",");
            for (String knowledgeCatalogId : knowledgeCatalogIdArray){
                SysRoleKnowledgeCatalog sysRoleKnowledgeCatalog = new SysRoleKnowledgeCatalog();
                sysRoleKnowledgeCatalog.setRoleId(roleId);
                sysRoleKnowledgeCatalog.setCatalogId(Long.valueOf(knowledgeCatalogId));
                sysRoleKnowledgeCatalog.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                sysRoleKnowledgeCatalogList.add(sysRoleKnowledgeCatalog);
            }
        }
        this.insertList(sysRoleKnowledgeCatalogList);
    }
}
