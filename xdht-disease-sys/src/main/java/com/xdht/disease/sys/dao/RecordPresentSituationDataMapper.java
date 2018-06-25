package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPresentSituationData;

import java.util.List;
import java.util.Map;

public interface RecordPresentSituationDataMapper extends Mapper<RecordPresentSituationData> {

    /**
     * 获取 现状评价 数据
     * @param id 调查记录表 id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByPreEvaluationId(Long id);
}