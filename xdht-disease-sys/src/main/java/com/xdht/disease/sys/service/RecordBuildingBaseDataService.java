package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordBuildingBaseDataService extends Service<RecordBuildingBaseData> {

    /**
     * 查询
     * @param recordBuildingBaseDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordBuildingBaseData> queryList(RecordBuildingBaseDataRequest recordBuildingBaseDataRequest);

    /**
     * 分页查询
     * @param recordBuildingBaseDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordBuildingBaseData> queryListPage(RecordBuildingBaseDataRequest recordBuildingBaseDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordBuildingBaseData 实体
     * @return 返回结果
     */
    public RecordBuildingBaseData add(RecordBuildingBaseData recordBuildingBaseData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordBuildingBaseData delete(Long id);

    /**
     * 修改
     * @param recordBuildingBaseData 实体
     * @return 返回结果
     */
    public RecordBuildingBaseData update(RecordBuildingBaseData recordBuildingBaseData);

    List<Map<String,Object>> queryRecordBuildingBaseDataByPostPersonnel(Long recordId);
}
