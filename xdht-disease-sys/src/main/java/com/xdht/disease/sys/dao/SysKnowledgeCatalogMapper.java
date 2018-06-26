package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysKnowledgeCatalog;

import java.util.Map;

public interface SysKnowledgeCatalogMapper extends Mapper<SysKnowledgeCatalog> {

    /**
     * 删除子目录
     * @return 返回结果
     */
    public Integer deleteChild(Map<String, Object> map);

}