package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.RecordIndividualNoise;
import com.xdht.disease.sys.vo.response.RecordIndividualNoiseResponse;

import java.util.List;

public interface RecordIndividualNoiseMapper extends Mapper<RecordIndividualNoise> {

    /**
     * 查询echarts信息
     * @return 返回结果
     */
    List<RecordIndividualNoiseResponse> selectRecordIndividualNoiseEcharsDetail();
}