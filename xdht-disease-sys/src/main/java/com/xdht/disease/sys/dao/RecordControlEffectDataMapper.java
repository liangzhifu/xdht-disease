package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordControlEffectData;

import java.util.List;
import java.util.Map;

public interface RecordControlEffectDataMapper extends Mapper<RecordControlEffectData> {
    /**
     * 列表数据
     * @param id 控制效果评价 id
     * @return 返回结果
     */
    List<Map<String,Object>> selectRecordDataByPreEvaluationId(Long id);
}