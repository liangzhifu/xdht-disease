package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordScene;

import java.util.Map;

public interface RecordSceneMapper extends Mapper<RecordScene> {

    /**
     * 获取职业卫生现场调查记录表--内容
     * @param id 主键ID
     * @return 返回结果
     */
    public Map<String, Object> selectRecordSceneMapByPrimaryKey(Long id);

}