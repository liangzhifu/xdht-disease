package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
import com.xdht.disease.sys.vo.response.RecordFundsDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordFundsService extends Service<RecordFunds> {

    /**
     * 查询
     * @param recordFundsRequest 查询条件
     * @return 返回结果
     */
    public List<RecordFunds> queryList(RecordFundsRequest recordFundsRequest);

    /**
     * 分页查询
     * @param recordFundsRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordFunds> queryListPage(RecordFundsRequest recordFundsRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordFundsRequest 实体
     * @return 返回结果
     */
    public void add(RecordFundsRequest recordFundsRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordFunds delete(Long id);

    /**
     * 修改
     * @param recordFundsRequest 实体
     * @return 返回结果
     */
    public void update(RecordFundsRequest recordFundsRequest);

    RecordFundsDetailResponse queryRecordFundsDetail(Long id);
}
