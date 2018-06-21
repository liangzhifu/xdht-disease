package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysDictionary;
import com.xdht.disease.sys.model.SysRole;
import com.xdht.disease.sys.service.SysDictionaryService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysDictionaryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


@Service
@Transactional
public class SysDictionaryServiceImpl extends AbstractService<SysDictionary> implements SysDictionaryService {

    @Override
    public PageResult<SysDictionary> querySysDictionaryPage(SysDictionaryRequest sysDictionaryRequest) {
        Condition condition = new Condition(SysRole.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
            .andEqualTo("dictionaryTypeId", sysDictionaryRequest.getDictionaryTypeId());
        if (sysDictionaryRequest.getDictionaryName() != null){
            condition.getOredCriteria().get(0).andLike("dictionaryName", "%" + sysDictionaryRequest.getDictionaryName() + "%");
        }
        PageHelper.startPage(sysDictionaryRequest.getPageNumber(), sysDictionaryRequest.getPageSize());
        List<SysDictionary> dataList = this.selectByCondition(condition);
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysDictionary> pageList = new PageResult<>();
        pageList.setDataList(dataList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public void addRole(SysDictionary sysDictionary) {
        sysDictionary.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysDictionary);
    }

    @Override
    public void deleteRole(Long id) {
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setId(id);
        sysDictionary.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysDictionary);
    }

    @Override
    public void updateRole(SysDictionary sysDictionary) {
        this.updateByPrimaryKeySelective(sysDictionary);
    }

}
