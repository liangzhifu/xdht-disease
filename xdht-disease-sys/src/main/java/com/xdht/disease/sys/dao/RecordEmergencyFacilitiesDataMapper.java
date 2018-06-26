package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;

import java.util.List;
import java.util.Map;

public interface RecordEmergencyFacilitiesDataMapper extends Mapper<RecordEmergencyFacilitiesData> {

    /**
     * 查询应急设施调查表
     * @param id 记录调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByEmergency(Long id);
}