package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;

import java.util.List;

public interface RecordEmployeeSummaryMapper extends Mapper<RecordEmployeeSummary> {

    /**
     * 查询个人体检列表
     * @param recordEmployeeSummaryRequest 查询条件
     * @return 返回结果
     */
    List<RecordEmployeeSummaryResponse> selectRecordEmployeeSummaryList(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest);

    /**
     * 查询个人体检数量
     * @param recordEmployeeSummaryRequest 查询条件
     * @return 返回结果
     */
    Integer selectRecordEmployeeSummaryCount(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest);

    /**
     * 查询个人体检信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordEmployeeSummaryResponse selectRecordEmployeeSummaryDetail(Long id);

    /**
     * 查询个人最近3年的体检信息
     * @param empId 员工id
     * @return 返回结果
     */
    List<RecordEmployeeSummaryResponse> selectRecordEmployeeSummaryEcharsDetail(Long empId);
}