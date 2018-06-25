package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordWorkLog;

import java.util.Map;

public interface RecordWorkLogMapper extends Mapper<RecordWorkLog> {

    /**
     * 查询 工作日写实记录表
     * @param id 记录表主键id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}