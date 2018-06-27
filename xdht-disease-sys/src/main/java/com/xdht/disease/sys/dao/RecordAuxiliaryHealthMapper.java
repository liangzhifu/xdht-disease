package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;

import java.util.Map;

public interface RecordAuxiliaryHealthMapper extends Mapper<RecordAuxiliaryHealth> {

    Map<String,Object> selectAuxiliaryHealthBySceneId(Long id);
}