package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordEquipmentDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentService extends Service<RecordEquipment> {

    /**
     * 查询
     * @param recordEquipmentRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEquipment> queryList(RecordEquipmentRequest recordEquipmentRequest);

    /**
     * 分页查询
     * @param recordEquipmentRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordEquipment> queryListPage(RecordEquipmentRequest recordEquipmentRequest);

    /**
     * 添加
     * @param recordEquipmentInputRequest 实体
     * @return 返回结果
     */
    public RecordEquipment add(RecordEquipmentInputRequest recordEquipmentInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEquipment delete(Long id);

    /**
     * 修改
     * @param recordEquipmentInputRequest 实体
     * @return 返回结果
     */
    public RecordEquipment update(RecordEquipmentInputRequest recordEquipmentInputRequest);

    /**
     * 获取 设备设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordEquipmentDetailResponse queryEquipmentDetail(Long id);
}
