package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysRoleKnowledgeCatalog;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogEditRequest;
import com.xdht.disease.sys.vo.request.SysRoleKnowledgeCatalogQueryRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/26.
 */
public interface SysRoleKnowledgeCatalogService extends Service<SysRoleKnowledgeCatalog> {

    /**
     * 查询角色菜单列表
     * @param sysRoleKnowledgeCatalogQueryRequest 查询条件
     * @return 返回结果
     */
    List<SysRoleKnowledgeCatalog> querySysRoleKnowledgeCatalogList(SysRoleKnowledgeCatalogQueryRequest sysRoleKnowledgeCatalogQueryRequest);

    /**
     * 修改角色菜单
     * @param sysRoleKnowledgeCatalogEditRequest 修改数据
     * @return 返回结果
     */
    void updateRoleKnowledgeCatalog(SysRoleKnowledgeCatalogEditRequest sysRoleKnowledgeCatalogEditRequest);
}
