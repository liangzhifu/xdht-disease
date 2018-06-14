package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPostPersonnelService extends Service<RecordPostPersonnel> {

//    /**
//     * 查询
//     * @param recordRequest 查询条件
//     * @return 返回结果
//     */
//    public List<RecordPostPersonnel> queryList(RecordPostPersonnelRequest recordRequest);
//
//    /**
//     * 分页查询
//     * @param recordRequest 查询条件
//     * @param pageNum 页数
//     * @param pageSize 每页大小
//     * @return 返回结果
//     */
//    public PageResult<RecordPostPersonnel> queryListPage(RecordPostPersonnelRequest recordRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordPostPersonnel 实体
     * @return 返回结果
     */
    public RecordPostPersonnel add(RecordPostPersonnel recordPostPersonnel);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPostPersonnel delete(Long id);

    /**
     * 修改
     * @param recordPostPersonnel 实体
     * @return 返回结果
     */
    public RecordPostPersonnel update(RecordPostPersonnel recordPostPersonnel);
}
