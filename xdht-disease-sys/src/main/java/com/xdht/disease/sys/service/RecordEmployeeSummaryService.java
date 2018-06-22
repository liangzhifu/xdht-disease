package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/21.
 */
public interface RecordEmployeeSummaryService extends Service<RecordEmployeeSummary> {
    /**
     * 查询
     * @param RecordEmployeeSummary 查询条件
     * @return 返回结果
     */
    public List<RecordEmployeeSummary> queryList(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest);

    /**
     * 分页查询
     * @param RecordEmployeeSummaryRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordEmployeeSummary> queryListPage(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest);

    /**
     * 添加
     * @param RecordEmployeeSummary 实体
     * @return 返回结果
     */
    public RecordEmployeeSummary add(RecordEmployeeSummaryResponse recordEmployeeSummaryResponse);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEmployeeSummary delete(Long id);

    /**
     * 修改
     * @param RecordEmployeeSummary 实体
     * @return 返回结果
     */
    public RecordEmployeeSummaryResponse update(RecordEmployeeSummaryResponse recordEmployeeSummaryResponse);

    /**
     * 根据ID查询
     * @param ID
     * @return 返回结果
     */
    RecordEmployeeSummaryResponse getRecordEmployeeSummaryDetail(Long id);
}
