package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.model.SysDictionary;
import com.xdht.disease.sys.model.SysDictionaryType;
import com.xdht.disease.sys.service.SysDictionaryService;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.service.SysDictionaryTypeService;
import com.xdht.disease.sys.vo.request.SysDictionaryRequest;
import com.xdht.disease.sys.vo.response.SysDictionaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
public class SysDictionaryServiceImpl extends AbstractService<SysDictionary> implements SysDictionaryService {

    @Autowired
    private SysDictionaryTypeService sysDictionaryTypeService;

    @Override
    public List<SysDictionary> querySysDictionaryList(SysDictionaryRequest sysDictionaryRequest) {
        Condition condition = new Condition(SysDictionary.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
                .andEqualTo("dictionaryTypeId", sysDictionaryRequest.getDictionaryTypeId());
        if (sysDictionaryRequest.getDictionaryName() != null && ! "".equals(sysDictionaryRequest.getDictionaryName())){
            condition.getOredCriteria().get(0).andLike("dictionaryName", "%" + sysDictionaryRequest.getDictionaryName() + "%");
        }
        return this.selectByCondition(condition);
    }

    @Override
    public PageResult<SysDictionaryResponse> querySysDictionaryPage(SysDictionaryRequest sysDictionaryRequest) {
        Condition condition = new Condition(SysDictionary.class);
        condition.createCriteria().andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode())
            .andEqualTo("dictionaryTypeId", sysDictionaryRequest.getDictionaryTypeId());
        if (sysDictionaryRequest.getDictionaryName() != null && ! "".equals(sysDictionaryRequest.getDictionaryName())){
            condition.getOredCriteria().get(0).andLike("dictionaryName", "%" + sysDictionaryRequest.getDictionaryName() + "%");
        }
        PageHelper.startPage(sysDictionaryRequest.getPageNumber(), sysDictionaryRequest.getPageSize());
        List<SysDictionary> dataList = this.selectByCondition(condition);
        List<SysDictionaryResponse> sysDictionaryResponseList = new LinkedList<>();
        List<SysDictionaryType> sysDictionaryTypeList = sysDictionaryTypeService.selectAll();
        for (SysDictionary sysDictionary : dataList) {
            SysDictionaryResponse sysDictionaryResponse = new SysDictionaryResponse();
            sysDictionaryResponse.setId(sysDictionary.getId());
            sysDictionaryResponse.setDictionaryName(sysDictionary.getDictionaryName());
            sysDictionaryResponse.setDictionaryTypeId(sysDictionary.getDictionaryTypeId());
            for (SysDictionaryType sysDictionaryType : sysDictionaryTypeList){
                if (sysDictionaryType.getId().intValue() == sysDictionary.getDictionaryTypeId()) {
                    sysDictionaryResponse.setDictionaryTypeName(sysDictionaryType.getDictionaryTypeName());
                }
            }
            sysDictionaryResponseList.add(sysDictionaryResponse);
        }
        Integer count = this.selectCountByCondition(condition);
        PageResult<SysDictionaryResponse> pageList = new PageResult<>();
        pageList.setDataList(sysDictionaryResponseList);
        pageList.setTotal(count);
        return pageList;
    }

    @Override
    public void addDictionary(SysDictionary sysDictionary) {
        sysDictionary.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysDictionary);
    }

    @Override
    public void deleteDictionary(Long id) {
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setId(id);
        sysDictionary.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysDictionary);
    }

    @Override
    public void updateDictionary(SysDictionary sysDictionary) {
        this.updateByPrimaryKeySelective(sysDictionary);
    }

}
