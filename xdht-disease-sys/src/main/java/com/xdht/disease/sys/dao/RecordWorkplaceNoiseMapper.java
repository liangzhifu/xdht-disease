package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordWorkplaceNoise;
import com.xdht.disease.sys.vo.response.RecordWorkplaceNoiseResponse;

import java.util.List;

public interface RecordWorkplaceNoiseMapper extends Mapper<RecordWorkplaceNoise> {
    /**
     * 查询echarts信息
     * @return 返回结果
     */
    List<RecordWorkplaceNoiseResponse> selectRecordWorkplaceNoiseEcharsDetail();
}