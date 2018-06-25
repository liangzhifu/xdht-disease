package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPresentSituation;

import java.util.Map;

public interface RecordPresentSituationMapper extends Mapper<RecordPresentSituation> {
    /**
     * 获取 现状评价 数据
     * @param id 调查记录表id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}