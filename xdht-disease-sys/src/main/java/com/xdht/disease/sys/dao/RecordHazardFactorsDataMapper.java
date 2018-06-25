package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHazardFactorsData;

import java.util.List;
import java.util.Map;

public interface RecordHazardFactorsDataMapper extends Mapper<RecordHazardFactorsData> {

    /**
     * 查询职业病危害因素调查表 数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByHazardFactors(Long id);
}