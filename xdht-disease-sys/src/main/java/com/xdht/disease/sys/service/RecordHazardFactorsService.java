package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHazardFactorsService extends Service<RecordHazardFactors> {

    /**
     * 查询
     * @param recordHazardFactorsRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHazardFactors> queryList(RecordHazardFactorsRequest recordHazardFactorsRequest);

    /**
     * 分页查询
     * @param recordHazardFactorsRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordHazardFactors> queryListPage(RecordHazardFactorsRequest recordHazardFactorsRequest);

    /**
     * 添加
     * @param recordHazardFactors 实体
     * @return 返回结果
     */
    public RecordHazardFactors add(RecordHazardFactors recordHazardFactors);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHazardFactors delete(Long id);

    /**
     * 修改
     * @param recordHazardFactors 实体
     * @return 返回结果
     */
    public RecordHazardFactors update(RecordHazardFactors recordHazardFactors);
}
