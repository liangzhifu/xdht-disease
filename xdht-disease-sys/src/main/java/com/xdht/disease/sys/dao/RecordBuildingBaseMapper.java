package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordBuildingBase;

import java.util.Map;

public interface RecordBuildingBaseMapper extends Mapper<RecordBuildingBase> {
    Map<String,Object> selectRecordBuildingBaseBySceneId(Long id);
}