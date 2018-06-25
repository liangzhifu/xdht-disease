package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordProduct;

import java.util.Map;

public interface RecordProductMapper extends Mapper<RecordProduct> {

    /**
     * 查询 物料及产品调查表
     * @param id 记录调查表id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}