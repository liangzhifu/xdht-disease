package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordFunds;

import java.util.Map;

public interface RecordFundsMapper extends Mapper<RecordFunds> {
    Map<String,Object> selectRecordFundsBySceneId(Long id);
}