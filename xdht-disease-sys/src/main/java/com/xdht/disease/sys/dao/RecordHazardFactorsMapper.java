package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHazardFactors;

import java.util.Map;

public interface RecordHazardFactorsMapper extends Mapper<RecordHazardFactors> {

    /**
     * 查询 职业病危害因素调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}