package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentInputRequest;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
import com.xdht.disease.sys.vo.response.RecordVddEquipmentDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordVddEquipmentService extends Service<RecordVddEquipment> {

    /**
     * 查询
     * @param recordVddEquipmentRequest 查询条件
     * @return 返回结果
     */
    public List<RecordVddEquipment> queryList(RecordVddEquipmentRequest recordVddEquipmentRequest);

    /**
     * 分页查询
     * @param recordVddEquipmentRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordVddEquipment> queryListPage(RecordVddEquipmentRequest recordVddEquipmentRequest);

    /**
     * 添加
     * @param recordVddEquipmentInputRequest 实体
     * @return 返回结果
     */
    public RecordVddEquipment add(RecordVddEquipmentInputRequest recordVddEquipmentInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordVddEquipment delete(Long id);

    /**
     * 修改
     * @param recordVddEquipmentInputRequest 实体
     * @return 返回结果
     */
    public RecordVddEquipment update(RecordVddEquipmentInputRequest recordVddEquipmentInputRequest);

    /**
     * 获取 通风排毒除尘设施调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordVddEquipmentDetailResponse queryVddEquipmentDetail(Long id);
}
