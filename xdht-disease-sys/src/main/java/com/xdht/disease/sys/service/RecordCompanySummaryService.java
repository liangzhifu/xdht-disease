package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordCompanySummary;
import com.xdht.disease.sys.vo.request.DateRequest;
import com.xdht.disease.sys.vo.request.RecordCompanySummaryRequest;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryEchartsResponse;
import com.xdht.disease.sys.vo.response.RecordCompanySummaryResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordCompanySummaryService extends Service<RecordCompanySummary> {

    /**
     * 分页查询
     * @param recordCompanySummaryRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordCompanySummaryResponse> queryListPage(RecordCompanySummaryRequest recordCompanySummaryRequest);

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

    /**
     * 查询企业体检的信息
     * @return 返回结果
     */
    List<RecordCompanySummaryEchartsResponse> selectCompanySummaryEcharts(DateRequest dateRequest);

    /**
     * 查询百分比信息
     * @param dateRequest 日期参数值
     * @return 返回结果
     */
    List<RecordCompanySummaryEchartsResponse> selectCompanySummaryPercentEcharts(DateRequest dateRequest);

}
