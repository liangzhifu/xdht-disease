package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysKnowledge;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysKnowledgeRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/26.
 */
public interface SysKnowledgeService extends Service<SysKnowledge> {

    /**
     * 查询知识库列表--分页
     * @param sysKnowledgeRequest 查询条件
     * @return 返回结果
     */
    PageResult<SysKnowledge> querySysKnowledgePage(SysKnowledgeRequest sysKnowledgeRequest);

    /**
     * 查询知识库列表
     * @param sysKnowledgeRequest 请求条件
     * @return 返回结果
     */
    List<SysKnowledge> querySysKnowledgeList(SysKnowledgeRequest sysKnowledgeRequest);

    /**
     * 增加知识库
     * @param sysKnowledge 知识库实体
     */
    void addKnowledge(SysKnowledge sysKnowledge);

    /**
     * 删除知识库
     * @param id 知识库主键
     */
    void deleteKnowledge(Long id);

    /**
     * 更新知识库
     * @param sysKnowledge 知识库实体
     */
    void updateKnowledge(SysKnowledge sysKnowledge);
    
}
