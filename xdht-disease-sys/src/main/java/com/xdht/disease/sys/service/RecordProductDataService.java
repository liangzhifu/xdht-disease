package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordProductDataRequest;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordProductDataService extends Service<RecordProductData> {

    /**
     * 查询 物料及产品调查表 数据
     * @param id 调查表id
     * @return 返回结果
     */
    List<Map<String,Object>> queryRecordDataByProduct(Long id);
}
