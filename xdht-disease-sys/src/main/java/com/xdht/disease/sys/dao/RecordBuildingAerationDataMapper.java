package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordBuildingAerationData;

import java.util.List;
import java.util.Map;

public interface RecordBuildingAerationDataMapper extends Mapper<RecordBuildingAerationData> {

    List<Map<String,Object>> queryRecordBuildingAerationDataByPostPersonnel(Long id);
}