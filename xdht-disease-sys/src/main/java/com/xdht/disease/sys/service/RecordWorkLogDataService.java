package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordWorkLogData;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordWorkLogDataService extends Service<RecordWorkLogData> {

    /**
     * 查询 工作日写实记录表 调查表数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByorkLog(Long id);
}
