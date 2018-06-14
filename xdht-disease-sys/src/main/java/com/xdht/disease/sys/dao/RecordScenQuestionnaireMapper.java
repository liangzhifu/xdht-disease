package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;

import java.util.List;
import java.util.Map;

public interface RecordScenQuestionnaireMapper extends Mapper<RecordScenQuestionnaire> {

    /**
     * 获取职业卫生现场调查记录表--职业卫生调查内容
     * @param id 职业卫生现场调查记录--主键ID
     * @return 返回结果
     */
    public List<Map<String, Object>> selectRecordScenQuestionnaireMapListByRecordScen(Long id);

}