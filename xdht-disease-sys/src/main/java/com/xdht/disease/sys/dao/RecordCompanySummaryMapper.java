package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.vo.request.DateRequest;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryEchartsResponse;
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

    /**
     * 查询企业体检信息
     * @return 返回结果
     */
    List<RecordCompanySummaryEchartsResponse> selectCompanySummaryEcharts(DateRequest dateRequest);

    /**
     * 查询百分比信息
     * @param dateRequest
     * @return 返回结果
     */
    List<RecordCompanySummaryEchartsResponse> selectCompanySummaryPercentEcharts(DateRequest dateRequest);

}