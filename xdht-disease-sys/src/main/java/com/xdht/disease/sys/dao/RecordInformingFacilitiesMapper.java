package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordInformingFacilities;

import java.util.Map;

public interface RecordInformingFacilitiesMapper extends Mapper<RecordInformingFacilities> {

    /**
     * 查询职业病危害告知设施调查表
     * @param id 记录表id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}