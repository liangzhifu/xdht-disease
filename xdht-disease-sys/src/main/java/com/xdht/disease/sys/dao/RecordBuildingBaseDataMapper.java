package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordBuildingBaseData;

import java.util.List;
import java.util.Map;

public interface RecordBuildingBaseDataMapper extends Mapper<RecordBuildingBaseData> {
    List<Map<String,Object>> queryRecordBuildingBaseDataByPostPersonnel(Long id);
}