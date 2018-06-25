package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordControlEffectInputRequest;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;
import com.xdht.disease.sys.vo.response.RecordControlEffectDetailResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordControlEffectService extends Service<RecordControlEffect> {

    /**
     * 查询列表
     * @param recordControlEffectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordControlEffect> queryList(RecordControlEffectRequest recordControlEffectRequest);

    /**
     * 分页查询
     * @param recordControlEffectRequest 查询条件
     * @return 返回结果
     */
    public PageResult<RecordControlEffect> queryListPage(RecordControlEffectRequest recordControlEffectRequest);
    /**
     * 添加
     * @param recordControlEffectInputRequest 实体
     */
    public  void addRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest);

    /**
     * 删除
     * @param id 主键id
     */
    public void deleteRecordControlEffect(Long id);

    /**
     * 修改
     * @param recordControlEffectInputRequest 实体
     */
    public void updateRecordControlEffect(RecordControlEffectInputRequest recordControlEffectInputRequest);

    /**
     * 获取 建设项目概况调查表（控制效果评价） 的详细信息
     * @param id 主键id
     * @return 返回结果
     */
    RecordControlEffectDetailResponse queryRecordControlEffectDetail(Long id);
}
