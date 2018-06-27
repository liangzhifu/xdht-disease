package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordBuildingBase;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseRequest;
import com.xdht.disease.sys.vo.response.RecordBuildingBaseDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordBuildingBaseService extends Service<RecordBuildingBase> {

    /**
     * 查询
     * @param recordBuildingBaseRequest 查询条件
     * @return 返回结果
     */
    public List<RecordBuildingBase> queryList(RecordBuildingBaseRequest recordBuildingBaseRequest);

    /**
     * 分页查询
     * @param recordBuildingBaseRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordBuildingBase> queryListPage(RecordBuildingBaseRequest recordBuildingBaseRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordBuildingBase 实体
     * @return 返回结果
     */
    public void add(RecordBuildingBaseRequest recordBuildingBaseRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordBuildingBase delete(Long id);

    /**
     * 修改
     * @param recordBuildingBase 实体
     * @return 返回结果
     */
    public void update(RecordBuildingBaseRequest recordBuildingBaseRequest);

    RecordBuildingBaseDetailResponse queryPostPersonnelDetail(Long id);
}
