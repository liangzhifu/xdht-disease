package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPreEvaluation;

import java.util.Map;

public interface RecordPreEvaluationMapper extends Mapper<RecordPreEvaluation> {

    /**
     * 获取预评价表数据
     * @param id 调查记录表ID
     * @return 返回结果
     */
    public Map<String, Object> selectRecordPreEvaluationBySceneId(Long id);

}