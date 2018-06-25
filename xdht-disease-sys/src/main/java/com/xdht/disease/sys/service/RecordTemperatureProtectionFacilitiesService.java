package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.vo.request.RecordTemperatureInputRequest;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesRequest;
import com.xdht.disease.sys.vo.response.RecordTemperatureDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordTemperatureProtectionFacilitiesService extends Service<RecordTemperatureProtectionFacilities> {

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordTemperatureProtectionFacilities> queryListPage(RecordTemperatureProtectionFacilitiesRequest recordRequest);

    /**
     * 添加
     * @param recordTemperatureInputRequest 实体
     * @return 返回结果
     */
    public void add(RecordTemperatureInputRequest recordTemperatureInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public void delete(Long id);

    /**
     * 修改
     * @param recordTemperatureInputRequest 实体
     * @return 返回结果
     */
    public void update(RecordTemperatureInputRequest recordTemperatureInputRequest);

    /**
     * 获取 防高温设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordTemperatureDetailResponse queryTemperatureDetail(Long id);
}
