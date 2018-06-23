package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
import com.xdht.disease.sys.vo.response.RecordPreEvaluationDetailResponse;

public interface RecordPreEvaluationService extends Service<RecordPreEvaluation> {

    /**
     * 分页查询
     * @param recordPreEvaluationRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordPreEvaluation> queryListPage(RecordPreEvaluationRequest recordPreEvaluationRequest);

    /**
     * 添加
     * @param recordPreEvaluationInputRequest 实体
     */
    void add(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    void deleteRecordPreEvaluation(Long id);

    /**
     * 修改
     * @param recordPreEvaluationInputRequest 实体
     */
    void updateRecordPreEvaluation(RecordPreEvaluationInputRequest recordPreEvaluationInputRequest);

    /**
     * 获取建设项目概况调查表（预评价）详细内容
     * @param id 关联主键
     * @return 返回结果
     */
    RecordPreEvaluationDetailResponse queryRecordPreEvaluationDetail(Long id);
}
