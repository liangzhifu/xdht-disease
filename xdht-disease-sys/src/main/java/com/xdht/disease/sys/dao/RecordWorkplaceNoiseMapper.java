package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.vo.request.RecordWorkplaceNoiseRequest;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;

import java.util.List;
import java.util.Map;

public interface RecordWorkplaceNoiseMapper extends Mapper<RecordWorkplaceNoise> {
    /**
     * 查询echarts信息
     * @return 返回结果
     */
    List<RecordWorkplaceNoiseResponse> selectRecordWorkplaceNoiseEcharsDetail();

    /***
     * 查询工作场所噪声列表
     * @param recordWorkplaceNoiseRequest 查询条件
     * @return 返回结果
     */
    List<Map<String, Object>> selectRecordWorkplaceNoiseList(RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest);

    /**
     * 查询工作场所噪声数量
     * @param recordWorkplaceNoiseRequest 查询条件
     * @return 返回结果
     */
    Integer selectRecordWorkplaceNoiseCount(RecordWorkplaceNoiseRequest recordWorkplaceNoiseRequest);

}