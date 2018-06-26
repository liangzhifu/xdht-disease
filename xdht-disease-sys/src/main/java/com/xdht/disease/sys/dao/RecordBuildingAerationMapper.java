package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordBuildingAeration;

import java.util.Map;

public interface RecordBuildingAerationMapper extends Mapper<RecordBuildingAeration> {

    Map<String,Object> selectRecordBuildingAerationBySceneId(Long id);
}