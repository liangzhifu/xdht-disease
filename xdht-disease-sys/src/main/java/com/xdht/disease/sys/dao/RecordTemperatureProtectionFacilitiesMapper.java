package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;

import java.util.Map;

public interface RecordTemperatureProtectionFacilitiesMapper extends Mapper<RecordTemperatureProtectionFacilities> {

    /**
     * 查询防高温设施调查表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}