package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordProductData;

import java.util.List;
import java.util.Map;

public interface RecordProductDataMapper extends Mapper<RecordProductData> {

    /**
     * 查询物料及产品调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByProduct(Long id);
}