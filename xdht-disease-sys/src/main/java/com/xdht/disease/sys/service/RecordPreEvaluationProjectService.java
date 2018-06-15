package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordPreEvaluationProject;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPreEvaluationProjectService extends Service<RecordPreEvaluationProject> {

    /**
     * 查询
     * @param recordPreEvaluationProjectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPreEvaluationProject> queryList(RecordPreEvaluationProjectRequest recordPreEvaluationProjectRequest);

    /**
     * 添加
     * @param recordPreEvaluationProject 实体
     * @return 返回结果
     */
    public  RecordPreEvaluationProject add(RecordPreEvaluationProject recordPreEvaluationProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public  RecordPreEvaluationProject delete(Long id);

    /**
     * 修改
     * @param recordPreEvaluationProject 实体
     * @return 返回结果
     */
    public  RecordPreEvaluationProject update(RecordPreEvaluationProject recordPreEvaluationProject);

    /**
     * 查询所有
     * @return 返回结果
     */
    public List<RecordPreEvaluationProject> queryListAll();
}
