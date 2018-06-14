package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordScenQuestionnaireService extends Service<RecordScenQuestionnaire> {

    /**
     * 查询列表
     * @param recordScenQuestionnaireRequest 查询条件
     * @return 返回结果
     */
    List<RecordScenQuestionnaire> queryList(RecordScenQuestionnaireRequest recordScenQuestionnaireRequest);

    /**
     * 添加
     * @param recordScenQuestionnaireList 实体列表
     */
    void addRecordScenQuestionnaireList(List<RecordScenQuestionnaire> recordScenQuestionnaireList);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    RecordScenQuestionnaire deleteRecordScenQuestionnaire(Long id);

    /**
     * 修改
     * @param recordScenQuestionnaire 实体
     * @return 返回结果
     */
    RecordScenQuestionnaire updateRecordScenQuestionnaire(RecordScenQuestionnaire recordScenQuestionnaire);

    /**
     * 获取职业卫生现场调查记录表--职业卫生调查内容
     * @param id 职业卫生现场调查记录--主键ID
     * @return 返回结果
     */
    List<Map<String, Object>> queryRecordScenQuestionnaireMapListByRecordScen(Long id);
}
