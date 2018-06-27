package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHealthCareData;

import java.util.List;
import java.util.Map;

public interface RecordHealthCareDataMapper extends Mapper<RecordHealthCareData> {
    List<Map<String,Object>> queryRecordHealthCareDataByRecordHealthCareId(Long id);
}