package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordWorkLogInputRequest;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;
import com.xdht.disease.sys.vo.response.RecordWorkLogDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordWorkLogService extends Service<RecordWorkLog> {

    /**
     * 查询
     * @param recordWorkLogRequest 查询条件
     * @return 返回结果
     */
    public List<RecordWorkLog> queryList(RecordWorkLogRequest recordWorkLogRequest);

    /**
     * 分页查询
     * @param recordWorkLogRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordWorkLog> queryListPage(RecordWorkLogRequest recordWorkLogRequest);

    /**
     * 添加
     * @param recordWorkLogInputRequest 实体
     * @return 返回结果
     */
    public RecordWorkLog add(RecordWorkLogInputRequest recordWorkLogInputRequest);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordWorkLog delete(Long id);

    /**
     * 修改
     * @param recordWorkLogInputRequest 实体
     * @return 返回结果
     */
    public RecordWorkLog update(RecordWorkLogInputRequest recordWorkLogInputRequest);

    /**
     * 获取 工作日写实记录表 信息
     * @param id
     * @return
     */
    RecordWorkLogDetailResponse queryWorkLogDetail(Long id);
}
