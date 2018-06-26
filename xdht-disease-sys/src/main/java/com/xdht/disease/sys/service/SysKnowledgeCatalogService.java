package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysKnowledgeCatalog;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysKnowledgeCatalogRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/26.
 */
public interface SysKnowledgeCatalogService extends Service<SysKnowledgeCatalog> {

    /**
     * 查询目录列表
     * @param sysKnowledgeCatalogRequest 请求条件
     * @return 返回结果
     */
    List<SysKnowledgeCatalog> querySysKnowledgeCatalogList(SysKnowledgeCatalogRequest sysKnowledgeCatalogRequest);

    /**
     * 增加目录
     * @param sysKnowledgeCatalog 目录实体
     */
    void addKnowledgeCatalog(SysKnowledgeCatalog sysKnowledgeCatalog);

    /**
     * 删除目录
     * @param id 目录主键
     */
    void deleteKnowledgeCatalog(Long id);

    /**
     * 更新目录
     * @param sysKnowledgeCatalog 目录实体
     */
    void updateKnowledgeCatalog(SysKnowledgeCatalog sysKnowledgeCatalog);

}
