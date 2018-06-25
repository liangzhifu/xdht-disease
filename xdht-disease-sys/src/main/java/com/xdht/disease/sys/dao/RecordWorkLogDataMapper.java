package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordWorkLogData;

import java.util.List;
import java.util.Map;

public interface RecordWorkLogDataMapper extends Mapper<RecordWorkLogData> {

    /**
     * 查询 工作日写实记录表 调查表数据
     * @param id 调查表id
     * @return  返回结果
     */
    List<Map<String,Object>> selectRecordDataByWorkLog(Long id);
}