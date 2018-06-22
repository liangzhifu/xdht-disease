package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordCompanySummaryService extends Service<RecordCompanySummary> {

    /**
     * 查询
     * @param recordCompanySummaryRequest 查询条件
     * @return 返回结果
     */
    public List<RecordCompanySummary> queryList(RecordCompanySummaryRequest recordCompanySummaryRequest);

    /**
     * 分页查询
     * @param recordCompanySummaryRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordCompanySummary> queryListPage(RecordCompanySummaryRequest recordCompanySummaryRequest);

    /**
     * 添加
     * @param recordCompanySummary 实体
     * @return 返回结果
     */
    public RecordCompanySummary add(RecordCompanySummary recordCompanySummary);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordCompanySummary delete(Long id);

    /**
     * 修改
     * @param recordCompanySummary 实体
     * @return 返回结果
     */
    public RecordCompanySummary update(RecordCompanySummary recordCompanySummary);
}
