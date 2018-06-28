package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordBuildingBaseMapper;
import com.xdht.disease.sys.model.RecordBuildingBase;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.model.RecordPostPersonnel;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import com.xdht.disease.sys.service.RecordBuildingBaseDataService;
import com.xdht.disease.sys.service.RecordBuildingBaseService;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseRequest;
import com.xdht.disease.sys.vo.response.RecordBuildingBaseDetailResponse;
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
public class RecordBuildingBaseServiceImpl extends AbstractService<RecordBuildingBase> implements RecordBuildingBaseService{

    @Autowired
    private RecordBuildingBaseMapper recordBuildingBaseMapper;
    @Autowired
    private RecordBuildingBaseDataService recordBuildingBaseDataService;

    @Override
    public List<RecordBuildingBase> queryList(RecordBuildingBaseRequest recordBuildingBaseRequest) {
        RecordBuildingBase recordBuildingBase = recordBuildingBaseRequest.getRecordBuildingBase();
        Condition condition = new Condition(RecordBuildingBase.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingBase.getId())
                .andEqualTo("buildingBaseNo",recordBuildingBase.getBuildingBaseNo());
        if (recordBuildingBase.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingBase.getVerificationResult()+"%");
        }
        if (recordBuildingBase.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingBase.getStatus());
        }
        return this.recordBuildingBaseMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordBuildingBase> queryListPage(RecordBuildingBaseRequest recordBuildingBaseRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordBuildingBase.class);
        RecordBuildingBase recordBuildingBase = recordBuildingBaseRequest.getRecordBuildingBase();
        condition.createCriteria() .andEqualTo("id", recordBuildingBase.getId())
                .andEqualTo("buildingBaseNo",recordBuildingBase.getBuildingBaseNo());
        if (recordBuildingBase.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingBase.getVerificationResult()+"%");
        }
        if (recordBuildingBase.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingBase.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordBuildingBase> dataList = this.recordBuildingBaseMapper.selectByCondition(condition);
        PageResult<RecordBuildingBase> pageList = new  PageResult<RecordBuildingBase>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public void add(RecordBuildingBaseRequest recordBuildingBaseRequest) {
        RecordBuildingBase recordBuildingBase = recordBuildingBaseRequest.getRecordBuildingBase();
        recordBuildingBase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(recordBuildingBase);
        List<RecordBuildingBaseData> recordBuildingBaseDataList = new LinkedList<>();
        if (recordBuildingBaseRequest.getRecordBuildingBaseDataList() != null) {
            for (RecordBuildingBaseData recordBuildingBaseData : recordBuildingBaseRequest.getRecordBuildingBaseDataList()) {
                recordBuildingBaseData.setBuildingBaseId(recordBuildingBase.getId());
                recordBuildingBaseDataList.add(recordBuildingBaseData);
            }
            this.recordBuildingBaseDataService.insertList(recordBuildingBaseDataList);
        }
    }

    @Override
    public RecordBuildingBase delete(Long id) {
            this.recordBuildingBaseMapper.deleteByPrimaryKey(id);
            RecordBuildingBase recordBuildingBase = new RecordBuildingBase();
            recordBuildingBase.setId(id);
            return  recordBuildingBase;
    }

    @Override
    public void update(RecordBuildingBaseRequest recordBuildingBaseRequest) {
        RecordBuildingBase recordBuildingBase = recordBuildingBaseRequest.getRecordBuildingBase();
        this.recordBuildingBaseMapper.updateByPrimaryKeySelective(recordBuildingBase);
        Condition condition = new Condition(RecordBuildingBaseData.class);
        condition.createCriteria().andEqualTo("buildingBaseId", recordBuildingBase.getId());
        List<RecordBuildingBaseData> recordBuildingBaseDatas = this.recordBuildingBaseDataService.selectByCondition(condition);
        if (recordBuildingBaseDatas != null && recordBuildingBaseDatas.size() > 0) {
            for (RecordBuildingBaseData recordBuildingBaseData : recordBuildingBaseDatas) {
                this.recordBuildingBaseDataService.deleteByPrimaryKey(recordBuildingBaseData.getId());
            }
        }
        recordBuildingBaseDatas = new LinkedList<>();
        if (recordBuildingBaseRequest.getRecordBuildingBaseDataList() != null) {
            for (RecordBuildingBaseData recordBuildingBaseData : recordBuildingBaseRequest.getRecordBuildingBaseDataList()) {
                recordBuildingBaseData.setBuildingBaseId(recordBuildingBase.getId());
                recordBuildingBaseDatas.add(recordBuildingBaseData);
            }
            this.recordBuildingBaseDataService.insertList(recordBuildingBaseDatas);
        }
    }

    @Override
    public RecordBuildingBaseDetailResponse queryPostPersonnelDetail(Long id) {
        RecordBuildingBaseDetailResponse response = new RecordBuildingBaseDetailResponse();
        //根据sceneId 获取表的数据
        Map<String, Object> map = this.recordBuildingBaseMapper.selectRecordBuildingBaseBySceneId(id);
        if (map != null) {
            response.setRecordBuildingBase(map);
            Long recordId = (Long) map.get("id");
            List<Map<String, Object>> mapList = this.recordBuildingBaseDataService.queryRecordBuildingBaseDataByPostPersonnel(recordId);
            response.setRecordBuildingBaseDataList(mapList);
        }
        return response;
    }
}
