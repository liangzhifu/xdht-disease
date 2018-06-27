package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;

import java.util.List;
import java.util.Map;

public interface RecordAuxiliaryHealthDataMapper extends Mapper<RecordAuxiliaryHealthData> {
    List<Map<String,Object>> queryAuxiliaryHealthDataByAuxiliary(Long id);
}