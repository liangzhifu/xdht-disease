package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordControlEffectProject;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordControlEffectProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordControlEffectProjectService extends Service<RecordControlEffectProject> {

    /**
     * 查询
     * @param recordControlEffectProjectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordControlEffectProject> queryList(RecordControlEffectProjectRequest recordControlEffectProjectRequest);

    /**
     * 添加
     * @param recordControlEffectProject 实体
     * @return 返回结果
     */
    public RecordControlEffectProject add(RecordControlEffectProject recordControlEffectProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordControlEffectProject delete(Long id);

    /**
     * 修改
     * @param recordControlEffectProject 实体
     * @return 返回结果
     */
    public RecordControlEffectProject update(RecordControlEffectProject recordControlEffectProject);

}
