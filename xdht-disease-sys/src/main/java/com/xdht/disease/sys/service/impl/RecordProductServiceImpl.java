package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordProductMapper;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.sys.model.SysCompanyOffice;
import com.xdht.disease.sys.service.RecordProductDataService;
import com.xdht.disease.sys.service.RecordProductService;
import com.xdht.disease.sys.service.SysCompanyOfficeService;
import com.xdht.disease.sys.vo.request.RecordProductInputRequest;
import com.xdht.disease.sys.vo.request.RecordProductRequest;
import com.xdht.disease.sys.vo.response.RecordProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordProductServiceImpl extends AbstractService<RecordProduct> implements RecordProductService{

    @Autowired
    private RecordProductMapper recordProductMapper;

    @Autowired
    private RecordProductDataService recordProductDataService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Override
    public List<RecordProduct> queryList(RecordProductRequest recordProductRequest) {
        Condition condition = new Condition(RecordProduct.class);
        condition.createCriteria() .andEqualTo("id", recordProductRequest.getId())
                .andEqualTo("productNo",recordProductRequest.getProductNo());
        if (recordProductRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordProductRequest.getVerificationResult()+"%");
        }
        if (recordProductRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordProductRequest.getStatus());
        }
        return this.recordProductMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordProduct> queryListPage(RecordProductRequest recordProductRequest) {
        Condition condition = new Condition(RecordProduct.class);
        condition.createCriteria() .andEqualTo("id", recordProductRequest.getId());
        if (recordProductRequest.getProductNo() != null) {
            condition.getOredCriteria().get(0).andLike("productNo","%"+recordProductRequest.getProductNo()+"%");
        }
        if (recordProductRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordProductRequest.getVerificationResult()+"%");
        }
        if (recordProductRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordProductRequest.getStatus());
        }
        PageHelper.startPage(recordProductRequest.getPageNumber(), recordProductRequest.getPageSize());
        List<RecordProduct> dataList = this.recordProductMapper.selectByCondition(condition);
        Integer count = this.recordProductMapper.selectCountByCondition(condition);
        PageResult<RecordProduct> pageList = new  PageResult<RecordProduct>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordProduct add(RecordProductInputRequest recordProductInputRequest) {
        RecordProduct recordProduct = new RecordProduct();
        recordProduct.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordProduct.setProductNo(recordProductInputRequest.getRecordProduct().getProductNo());
        recordProduct.setVerificationResult(recordProductInputRequest.getRecordProduct().getVerificationResult());
        this.insertUseGeneratedKeys(recordProduct);
        List<RecordProductData> recordProductDataList = new LinkedList<>();
        for (RecordProductData recordProductData : recordProductInputRequest.getRecordProductDataList()) {
            recordProductData.setRelationId(recordProduct.getId());
            recordProductDataList.add(recordProductData);
        }
        this.recordProductDataService.insertList(recordProductDataList);
        return  recordProduct;
    }

    @Override
    public RecordProduct delete(Long id) {
        RecordProduct recordProduct = this.recordProductMapper.selectByPrimaryKey(id);
        recordProduct.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordProductMapper.updateByPrimaryKeySelective(recordProduct);
        return  recordProduct;
    }

    @Override
    public RecordProduct update(RecordProductInputRequest recordProductInputRequest) {
        RecordProduct recordProduct = recordProductInputRequest.getRecordProduct();
        this.recordProductMapper.updateByPrimaryKeySelective(recordProduct);
        List<RecordProductData> recordProductDataList = new LinkedList<>();
        for ( RecordProductData recordProductData : recordProductInputRequest.getRecordProductDataList() ) {
            if (recordProductData.getId() == null){
                recordProductData.setRelationId(recordProduct.getId());
                recordProductDataList.add(recordProductData);
            }
            this.recordProductDataService.updateByPrimaryKeySelective(recordProductData);
        }
        if (recordProductDataList.size()>0){
            this.recordProductDataService.insertList(recordProductDataList);
        }
        return  recordProduct;
    }

    @Override
    public RecordProductDetailResponse queryProductDetail(Long id) {
        RecordProductDetailResponse response = new RecordProductDetailResponse();
        RecordProduct recordProduct = this.recordProductMapper.selectByPrimaryKey(id);
        response.setRecordProduct(recordProduct);
        Condition condition = new Condition(RecordProductData.class);
        condition.createCriteria() .andEqualTo("relationId", id);
        List<RecordProductData> recordProductDataList = this.recordProductDataService.selectByCondition(condition);
        response.setRecordProductDataList(recordProductDataList);
        String officeIds = "";
        for (RecordProductData recordData : recordProductDataList) {
            officeIds += recordData.getCompanyOfficeId()+",";
        }
        officeIds = officeIds.substring(0,officeIds.lastIndexOf(","));
        List<SysCompanyOffice> officeList = this.sysCompanyOfficeService.selectByIds(officeIds);
        response.setSysCompanyOfficeList(officeList);
        return response;
    }
}
