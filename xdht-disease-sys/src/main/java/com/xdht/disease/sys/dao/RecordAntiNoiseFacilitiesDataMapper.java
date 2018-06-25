package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;

import java.util.List;
import java.util.Map;

public interface RecordAntiNoiseFacilitiesDataMapper extends Mapper<RecordAntiNoiseFacilitiesData> {

    /**
     * 查询防噪声设施调查表
     * @param id 记录调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByAntiNoise(Long id);
}