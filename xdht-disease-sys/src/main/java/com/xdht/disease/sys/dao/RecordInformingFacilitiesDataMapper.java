package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;

import java.util.List;
import java.util.Map;

public interface RecordInformingFacilitiesDataMapper extends Mapper<RecordInformingFacilitiesData> {

    /**
     * 查询职业病危害告知设施调查表
     * @param id 记录调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByInformingFacilities(Long id);
}