package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEquipmentDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentDataService extends Service<RecordEquipmentData> {

    /**
     * 查询 设备设施调查表 数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByEquipment(Long id);
}
