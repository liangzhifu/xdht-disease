package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;

import java.util.List;
import java.util.Map;

public interface RecordTemperatureProtectionFacilitiesDataMapper extends Mapper<RecordTemperatureProtectionFacilitiesData> {

    /**
     *  查询防高温设施调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByTemperatureProtection(Long id);
}