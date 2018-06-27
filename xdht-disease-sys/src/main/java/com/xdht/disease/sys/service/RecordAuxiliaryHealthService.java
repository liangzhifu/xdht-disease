package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
import com.xdht.disease.sys.vo.response.RecordAuxiliaryHealthResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordAuxiliaryHealthService extends Service<RecordAuxiliaryHealth> {

    /**
     * 查询
     * @param recordAuxiliaryHealthRequest 查询条件
     * @return 返回结果
     */
    public List<RecordAuxiliaryHealth> queryList(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest);

    /**
     * 分页查询
     * @param recordAuxiliaryHealthRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordAuxiliaryHealth> queryListPage(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordAuxiliaryHealthRequest 实体
     * @return 返回结果
     */
    public void add(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordAuxiliaryHealth delete(Long id);

    /**
     * 修改
     * @param recordAuxiliaryHealthRequest 实体
     * @return 返回结果
     */
    public void update(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest);

    RecordAuxiliaryHealthResponse queryAuxiliaryHealthDetail(Long id);
}
