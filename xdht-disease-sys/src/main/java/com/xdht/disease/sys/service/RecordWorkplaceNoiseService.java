package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.vo.request.RecordWorkplaceNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;

import java.util.List;


/**
 * Created by lzf on 2018/07/11.
 */
public interface RecordWorkplaceNoiseService extends Service<RecordWorkplaceNoise> {

    /**
     * 分页查询
     * @param recordWorkplaceNoiseRequest
     * @return 返回结果
     */
    PageResult<RecordWorkplaceNoise> queryListPage(RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest);

    /**
     * 新增
     * @param recordWorkplaceNoise
     */
    void add(RecordWorkplaceNoise recordWorkplaceNoise);

    /**
     * 删除
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改
     * @param recordWorkplaceNoise
     */
    void update(RecordWorkplaceNoise recordWorkplaceNoise);

    /**
     * 查询详情
     * @param id 主键id
     * @return 返回结果
     */
    RecordWorkplaceNoise queryNoiseDetail(Long id);

    /**
     * 获取echarts信息
     * @return 返回结果
     */
    List<RecordWorkplaceNoiseResponse> queryNoiseEchartsDetail();
}
