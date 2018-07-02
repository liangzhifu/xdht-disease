package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryResponse;

import java.util.List;

public interface RecordCompanySummaryMapper extends Mapper<RecordCompanySummary> {

    /**
     * 查询企业体检列表
     * @param recordCompanySummaryRequest 查询条件
     * @return 返回结果
     */
    List<RecordCompanySummaryResponse> setRecordCompanySummaryList(RecordCompanySummaryRequest recordCompanySummaryRequest);

    /**
     * 查询企业体检数量
     * @param recordCompanySummaryRequest 查询条件
     * @return 返回结果
     */
    Integer setRecordCompanySummaryCount(RecordCompanySummaryRequest recordCompanySummaryRequest);

}