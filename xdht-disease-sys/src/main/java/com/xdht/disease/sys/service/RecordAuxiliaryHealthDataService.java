package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordAuxiliaryHealthDataService extends Service<RecordAuxiliaryHealthData> {

    /**
     * 查询
     * @param recordAuxiliaryHealthDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordAuxiliaryHealthData> queryList(RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest);

    /**
     * 分页查询
     * @param recordAuxiliaryHealthDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordAuxiliaryHealthData> queryListPage(RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordAuxiliaryHealthData 实体
     * @return 返回结果
     */
    public RecordAuxiliaryHealthData add(RecordAuxiliaryHealthData recordAuxiliaryHealthData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordAuxiliaryHealthData delete(Long id);

    /**
     * 修改
     * @param recordAuxiliaryHealthData 实体
     * @return 返回结果
     */
    public RecordAuxiliaryHealthData update(RecordAuxiliaryHealthData recordAuxiliaryHealthData);

    List<Map<String,Object>> queryRecordAuxiliaryHealthDataByAuxiliaryHealth(Long recordId);
}
