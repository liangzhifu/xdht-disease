package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordVddEquipmentData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordVddEquipmentDataService extends Service<RecordVddEquipmentData> {

    /**
     * 查询 通风排毒除尘设施调查表 数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByVddEquipment(Long id);
}
