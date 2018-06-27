package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHealthCare;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthCareRequest;
import com.xdht.disease.sys.vo.response.RecordHealthCareResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthCareService extends Service<RecordHealthCare> {

    /**
     * 查询
     * @param recordHealthCareRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthCare> queryList(RecordHealthCareRequest recordHealthCareRequest);

    /**
     * 分页查询
     * @param recordHealthCareRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordHealthCare> queryListPage(RecordHealthCareRequest recordHealthCareRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordHealthCare 实体
     * @return 返回结果
     */
    public void add(RecordHealthCareRequest recordHealthCareRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHealthCare delete(Long id);

    /**
     * 修改
     * @param recordHealthCare 实体
     * @return 返回结果
     */
    public void update(RecordHealthCareRequest recordHealthCareRequest);

    RecordHealthCareResponse queryRecordHealthCareDetail(Long id);
}
