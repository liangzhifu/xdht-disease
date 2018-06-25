package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.vo.request.RecordProductInputRequest;
import com.xdht.disease.sys.vo.request.RecordProductRequest;
import com.xdht.disease.sys.vo.response.RecordProductDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordProductService extends Service<RecordProduct> {


    /**
     * 分页查询
     * @param recordProductRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordProduct> queryListPage(RecordProductRequest recordProductRequest);

    /**
     * 添加
     * @param recordProductInputRequest 实体
     */
    public  void add(RecordProductInputRequest recordProductInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public  void delete(Long id);

    /**
     * 修改
     * @param recordProductInputRequest 实体
     */
    public  void update(RecordProductInputRequest recordProductInputRequest);

    /**
     * 获取 - 物料及产品调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordProductDetailResponse queryProductDetail(Long id);
}
