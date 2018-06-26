package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseInputRequest;
import com.xdht.disease.sys.vo.response.RecordAntiNoiseDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordAntiNoiseFacilitiesService extends Service<RecordAntiNoiseFacilities> {


    /**
     * 分页查询
     * @param recordAntiNoiseFacilitiesRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordAntiNoiseFacilities> queryListPage(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest);

    /**
     * 添加
     * @param recordAntiNoiseInputRequest 实体
     */
    public void addRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public void deleteRecordAntiNoiseFacilities(Long id);

    /**
     * 修改
     * @param recordAntiNoiseInputRequest 实体
     */
    public void updateRecordAntiNoiseFacilities(RecordAntiNoiseInputRequest recordAntiNoiseInputRequest);

    /**
     * 获取 防噪声设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordAntiNoiseDetailResponse queryAntiNoiseDetail(Long id);
}
