package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesInputRequest;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordEmergencyFacilitiesDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEmergencyFacilitiesService extends Service<RecordEmergencyFacilities> {


    /**
     * 分页查询
     * @param recordEmergencyFacilitiesRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordEmergencyFacilities> queryListPage(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest);

    /**
     * 添加
     * @param recordEmergencyFacilitiesInputRequest 实体
     */
    public void add(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public void delete(Long id);

    /**
     * 修改
     * @param recordEmergencyFacilitiesInputRequest 实体
     */
    public void update(RecordEmergencyFacilitiesInputRequest recordEmergencyFacilitiesInputRequest);

    /**
     * 获取 应急设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordEmergencyFacilitiesDetailResponse queryEmergencyFacilitiesDetail(Long id);
}
