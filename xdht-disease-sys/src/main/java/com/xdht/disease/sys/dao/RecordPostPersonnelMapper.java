package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordPostPersonnel;

import java.util.Map;

public interface RecordPostPersonnelMapper extends Mapper<RecordPostPersonnel> {

    /**
     * 查询岗位定员及工作制度调查表
     * @param id 记录表主键ID
     * @return 返回结果
     */
    public Map<String, Object> selectRecordPostPersonnelBySceneId(Long id);

}