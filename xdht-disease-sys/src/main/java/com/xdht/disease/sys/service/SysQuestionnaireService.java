package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysQuestionnaireRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface SysQuestionnaireService extends Service<SysQuestionnaire> {

    /**
     * 查询
     * @param sysQuestionnaireRequest 查询条件
     * @return 返回结果
     */
    public List<SysQuestionnaire> queryList(SysQuestionnaireRequest sysQuestionnaireRequest);

    /**
     * 分页查询
     * @param sysQuestionnaireRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<SysQuestionnaire> queryListPage(SysQuestionnaireRequest sysQuestionnaireRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param sysQuestionnaire 实体
     * @return 返回结果
     */
    public SysQuestionnaire add(SysQuestionnaire sysQuestionnaire);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public SysQuestionnaire delete(Long id);

    /**
     * 修改
     * @param sysQuestionnaire 实体
     * @return 返回结果
     */
    public SysQuestionnaire update(SysQuestionnaire sysQuestionnaire);

    /**
     * 查询所有
     * @return 返回结果
     */
    public List<SysQuestionnaire> queryListAll();
}
