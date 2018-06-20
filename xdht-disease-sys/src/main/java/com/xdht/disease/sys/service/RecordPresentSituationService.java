package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPresentSituationInputRequest;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;
import com.xdht.disease.sys.vo.response.RecordPresentSituationDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPresentSituationService extends Service<RecordPresentSituation> {

    /**
     * 查询列表
     * @param recordPresentSituationRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPresentSituation> queryList(RecordPresentSituationRequest recordPresentSituationRequest);

    /**
     * 分页查询
     * @param recordPresentSituationRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordPresentSituation> queryListPage(RecordPresentSituationRequest recordPresentSituationRequest);

    /**
     * 添加
     * @param recordPresentSituationInputRequest 实体
     * @return 返回结果
     */
    public RecordPresentSituation addRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPresentSituation deleteRecordPresentSituation(Long id);

    /**
     * 修改
     * @param recordPresentSituationInputRequest 实体
     * @return 返回结果
     */
    public RecordPresentSituation updateRecordPresentSituation(RecordPresentSituationInputRequest recordPresentSituationInputRequest);

    /**
     * 获取 用人单位概况调查表（现状评价） 详细信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordPresentSituationDetailResponse queryRecordPresentSituationDetail(Long id);
}
