package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentLayoutDetailResponse;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentLayoutService extends Service<RecordEquipmentLayout> {


    /**
     * 分页查询
     * @param recordEquipmentLayoutRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordEquipmentLayout> queryListPage(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest);

    /**
     * 添加
     * @param recordEquipmentLayoutInputRequest 实体
     */
    public void add(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public void delete(Long id);

    /**
     * 修改
     * @param recordEquipmentLayoutInputRequest 实体
     */
    public void update(RecordEquipmentLayoutInputRequest recordEquipmentLayoutInputRequest);

    /**
     * 获取 设备设施布局调查表 详细信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordEquipmentLayoutDetailResponse queryEquipmentLayoutDetail(Long id);
}
