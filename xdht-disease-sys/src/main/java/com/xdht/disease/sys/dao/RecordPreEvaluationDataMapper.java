package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPreEvaluationData;

import java.util.List;
import java.util.Map;

public interface RecordPreEvaluationDataMapper extends Mapper<RecordPreEvaluationData> {

    /**
     * 列表数据
     * @param id 预评价id
     * @return 返回结果
     */
    public List<Map<String, Object>> selectRecordPreEvaluationDataByPreEvaluationId(Long id);

}