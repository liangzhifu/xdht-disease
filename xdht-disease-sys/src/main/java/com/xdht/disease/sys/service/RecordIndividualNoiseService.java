package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordIndividualNoise;
import com.xdht.disease.sys.vo.request.RecordIndividualNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordIndividualNoiseResponse;

import java.util.List;


/**
 * Created by lzf on 2018/07/11.
 */
public interface RecordIndividualNoiseService extends Service<RecordIndividualNoise> {

    /**
     * 添加
     * @param recordIndividualNoise
     */
    void add(RecordIndividualNoise recordIndividualNoise);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 修改
     * @param recordIndividualNoise
     */
    void update(RecordIndividualNoise recordIndividualNoise);

    /**
     * 查询详情
     * @param id 主键id结果
     * @return fanhui
     */
    RecordIndividualNoise queryNoiseDetail(Long id);

    /**
     * 分页查询
     * @param recordIndividualNoiseRequest
     * @return 返回结果
     */
    PageResult<RecordIndividualNoise> queryListPage(RecordIndividualNoiseRequest recordIndividualNoiseRequest);

    /**
     * 查询echarts信息
     * @return 返回结果
     */
    List<RecordIndividualNoiseResponse> queryNoiseEchartsDetail();
}
