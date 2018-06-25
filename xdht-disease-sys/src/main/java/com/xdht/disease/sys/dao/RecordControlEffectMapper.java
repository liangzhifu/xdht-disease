package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordControlEffect;

import java.util.Map;

public interface RecordControlEffectMapper extends Mapper<RecordControlEffect> {
    /**
     *  获取 建设项目概况调查表（控制效果评价）数据
     * @param id 调查记录表id
     * @return 返回结果
     */
    Map<String,Object> selectRecordBySceneId(Long id);
}