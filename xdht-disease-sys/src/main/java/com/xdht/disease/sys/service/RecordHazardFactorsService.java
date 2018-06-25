package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsInputRequest;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsRequest;
import com.xdht.disease.sys.vo.response.RecordHazardFactorsDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHazardFactorsService extends Service<RecordHazardFactors> {

    /**
     * 分页查询
     * @param recordHazardFactorsRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordHazardFactors> queryListPage(RecordHazardFactorsRequest recordHazardFactorsRequest);

    /**
     * 添加
     * @param recordHazardFactorsInputRequest 实体
     */
    public void add(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public void delete(Long id);

    /**
     * 修改
     * @param recordHazardFactorsInputRequest 实体
     */
    public void update(RecordHazardFactorsInputRequest recordHazardFactorsInputRequest);

    /**
     * 获取 职业病危害因素调查表 信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordHazardFactorsDetailResponse queryHazardFactorsDetail(Long id);
}
