package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordFundsData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordFundsDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordFundsDataService extends Service<RecordFundsData> {

    /**
     * 查询
     * @param recordFundsDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordFundsData> queryList(RecordFundsDataRequest recordFundsDataRequest);

    /**
     * 分页查询
     * @param recordFundsDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordFundsData> queryListPage(RecordFundsDataRequest recordFundsDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordFundsData 实体
     * @return 返回结果
     */
    public RecordFundsData add(RecordFundsData recordFundsData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordFundsData delete(Long id);

    /**
     * 修改
     * @param recordFundsData 实体
     * @return  返回结果
     */
    public RecordFundsData update(RecordFundsData recordFundsData);

    List<Map<String,Object>> queryRecordFundsDataByFundsId(Long recordId);
}
