package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordProductMapper;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordProductDataService;
import com.xdht.disease.sys.service.RecordProductService;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordProductInputRequest;
import com.xdht.disease.sys.vo.request.RecordProductRequest;
import com.xdht.disease.sys.vo.response.RecordProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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
    private RecordScenQuestionnaireService recordScenQuestionnaireService;


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
        condition.getOredCriteria().get(0).andEqualTo("status",recordProductRequest.getStatus());
        PageHelper.startPage(recordProductRequest.getPageNumber(), recordProductRequest.getPageSize());
        List<RecordProduct> dataList = this.recordProductMapper.selectByCondition(condition);
        Integer count = this.recordProductMapper.selectCountByCondition(condition);
        PageResult<RecordProduct> pageList = new  PageResult<RecordProduct>();
        pageList.setTotal(count);
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordProductInputRequest recordProductInputRequest) {
        RecordProduct recordProduct = recordProductInputRequest.getRecordProduct();
        recordProduct.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordProduct);

        // 修改调查表的编辑状态
        RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
        recordScenQuestionnaire.setQuestionnaireId(recordProductInputRequest.getQuestionnaireId());
        recordScenQuestionnaire.setSceneId(recordProductInputRequest.getRecordProduct().getSceneId());
        recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScenQuestionnaire = recordScenQuestionnaireService.selectOne(recordScenQuestionnaire);
        if (recordScenQuestionnaire != null) {
            recordScenQuestionnaire.setEditStatus(SysEnum.EditStauts.EDIT_STATUS.getCode());
            recordScenQuestionnaireService.updateByPrimaryKeySelective(recordScenQuestionnaire);
        }

        List<RecordProductData> recordProductDataList = new LinkedList<>();
        if (recordProductInputRequest.getRecordProductDataList().size() > 0){
            for (RecordProductData recordProductData : recordProductInputRequest.getRecordProductDataList()) {
                recordProductData.setRelationId(recordProduct.getId());
                recordProductDataList.add(recordProductData);
            }
            this.recordProductDataService.insertList(recordProductDataList);
        }
    }

    @Override
    public void delete(Long id) {
        RecordProduct recordProduct = this.recordProductMapper.selectByPrimaryKey(id);
        recordProduct.setId(id);
        recordProduct.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.recordProductMapper.updateByPrimaryKeySelective(recordProduct);;
    }

    @Override
    public void update(RecordProductInputRequest recordProductInputRequest) {
        RecordProduct recordProduct = recordProductInputRequest.getRecordProduct();
        this.recordProductMapper.updateByPrimaryKeySelective(recordProduct);

        Condition condition = new Condition(RecordProductData.class);
        condition.createCriteria().andEqualTo("relationId", recordProduct.getId());
        List<RecordProductData> recordProductDataList = this.recordProductDataService.selectByCondition(condition);
        if (recordProductDataList != null && recordProductDataList.size() > 0){
            for (RecordProductData recordProductData : recordProductDataList){
                this.recordProductDataService.deleteByPrimaryKey(recordProductData.getId());
            }
        }
       recordProductDataList = new LinkedList<>();
        if (recordProductInputRequest.getRecordProductDataList() != null){
            for ( RecordProductData recordProductData : recordProductInputRequest.getRecordProductDataList() ) {
                    recordProductData.setRelationId(recordProduct.getId());
                    recordProductDataList.add(recordProductData);
                }
            this.recordProductDataService.insertList(recordProductDataList);
        }
    }

    @Override
    public RecordProductDetailResponse queryProductDetail(Long id) {
        RecordProductDetailResponse response = new RecordProductDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordProductMapper.selectRecordBySceneId(id);
        if (map != null) {
            response.setRecordProduct(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordProductDataService.queryRecordDataByProduct(recordId);
            response.setRecordProductDataList(mapList);
        }
        return response;
    }
}
