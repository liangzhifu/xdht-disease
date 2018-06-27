package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHealthCareData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthCareDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthCareDataService extends Service<RecordHealthCareData> {

    /**
     * 查询
     * @param recordHealthCareDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthCareData> queryList(RecordHealthCareDataRequest recordHealthCareDataRequest);

    /**
     * 分页查询
     * @param recordHealthCareDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordHealthCareData> queryListPage(RecordHealthCareDataRequest recordHealthCareDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordHealthCareData 实体
     * @return 返回结果
     */
    public  RecordHealthCareData add(RecordHealthCareData recordHealthCareData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public  RecordHealthCareData delete(Long id);

    /**
     * 修改
     * @param recordHealthCareData 实体
     * @return 返回结果
     */
    public  RecordHealthCareData update(RecordHealthCareData recordHealthCareData);

    List<Map<String,Object>> queryRecordHealthCareDataByRecordHealthCareId(Long recordId);
}
