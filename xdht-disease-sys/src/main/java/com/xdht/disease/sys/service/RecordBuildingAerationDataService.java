package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordBuildingAerationData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordBuildingAerationDataService extends Service<RecordBuildingAerationData> {
    /**
     * 查询
     * @param recordBuildingAerationDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordBuildingAerationData> queryList(RecordBuildingAerationDataRequest recordBuildingAerationDataRequest);

    /**
     * 分页查询
     * @param recordBuildingAerationDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordBuildingAerationData> queryListPage(RecordBuildingAerationDataRequest recordBuildingAerationDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordBuildingAerationData 实体
     * @return 返回结果
     */
    public RecordBuildingAerationData add(RecordBuildingAerationData recordBuildingAerationData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordBuildingAerationData delete(Long id);

    /**
     * 修改
     * @param recordBuildingAerationData 实体
     * @return 返回结果
     */
    public RecordBuildingAerationData update(RecordBuildingAerationData recordBuildingAerationData);

    List<Map<String,Object>> queryRecordBuildingAerationDataByPostPersonnel(Long recordId);
}
