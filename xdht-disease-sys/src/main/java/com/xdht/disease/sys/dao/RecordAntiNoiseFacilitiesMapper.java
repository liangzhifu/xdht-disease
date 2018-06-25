package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;

import java.util.Map;

public interface RecordAntiNoiseFacilitiesMapper extends Mapper<RecordAntiNoiseFacilities> {

    /**
     * 查询防噪声设施调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}