package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordFundsData;

import java.util.List;
import java.util.Map;

public interface RecordFundsDataMapper extends Mapper<RecordFundsData> {
    List<Map<String,Object>> queryRecordFundsDataByFundsId(Long id);
}