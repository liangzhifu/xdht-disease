package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordHealthCare;

import java.util.Map;

public interface RecordHealthCareMapper extends Mapper<RecordHealthCare> {

    Map<String,Object> selectRecordHealthCareBySceneId(Long id);
}