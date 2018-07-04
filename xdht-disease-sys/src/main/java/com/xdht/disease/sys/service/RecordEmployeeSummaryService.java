package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEmployeeSummary;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEmployeeSummaryRequest;
import com.xdht.disease.sys.vo.response.RecordEmployeeSummaryResponse;


/**
 * Created by lzf on 2018/06/21.
 */
public interface RecordEmployeeSummaryService extends Service<RecordEmployeeSummary> {

    /**
     * 分页查询
     * @param recordEmployeeSummaryRequest 查询条件
     * @return 返回结果
     */
    PageResult<RecordEmployeeSummaryResponse> queryListPage(RecordEmployeeSummaryRequest recordEmployeeSummaryRequest);

    /**
     * 添加
     * @param recordEmployeeSummary 实体
     */
    void add(RecordEmployeeSummary recordEmployeeSummary);

    /**
     * 删除
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改
     * @param recordEmployeeSummary 实体
     */
    void update(RecordEmployeeSummary recordEmployeeSummary);

    /**
     * 根据ID查询
     * @param id 主键id
     * @return 返回结果
     */
    RecordEmployeeSummaryResponse getRecordEmployeeSummaryDetail(Long id);

}
