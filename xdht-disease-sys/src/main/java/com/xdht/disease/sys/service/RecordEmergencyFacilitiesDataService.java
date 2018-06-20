package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEmergencyFacilitiesDataService extends Service<RecordEmergencyFacilitiesData> {

    /**
     * 查询
     * @param recordEmergencyFacilitiesDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEmergencyFacilitiesData> queryList(RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest);

    /**
     * 分页查询
     * @param recordEmergencyFacilitiesDataRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordEmergencyFacilitiesData> queryListPage(RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest);

    /**
     * 添加
     * @param recordEmergencyFacilitiesData 实体
     * @return 返回结果
     */
    public RecordEmergencyFacilitiesData add(RecordEmergencyFacilitiesData recordEmergencyFacilitiesData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEmergencyFacilitiesData delete(Long id);

    /**
     * 修改
     * @param recordEmergencyFacilitiesData 实体
     * @return 返回结果
     */
    public RecordEmergencyFacilitiesData update(RecordEmergencyFacilitiesData recordEmergencyFacilitiesData);
}
