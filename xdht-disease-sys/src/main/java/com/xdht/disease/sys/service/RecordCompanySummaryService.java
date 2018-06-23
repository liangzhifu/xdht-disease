package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordCompanySummaryService extends Service<RecordCompanySummary> {

    /**
     * 分页查询
     * @param recordCompanySummaryRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordCompanySummary> queryListPage(RecordCompanySummaryRequest recordCompanySummaryRequest);

    /**
     * 添加
     * @param recordCompanySummary 实体
     */
    void add(RecordCompanySummary recordCompanySummary);

    /**
     * 删除
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改
     * @param recordCompanySummary 实体
     */
    void update(RecordCompanySummary recordCompanySummary);
}
