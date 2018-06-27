package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordBuildingBaseDataMapper;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.service.RecordBuildingBaseDataService;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordBuildingBaseDataServiceImpl extends AbstractService<RecordBuildingBaseData> implements RecordBuildingBaseDataService{

    @Autowired
    private RecordBuildingBaseDataMapper recordBuildingBaseDataMapper;

        @Override
        public List<RecordBuildingBaseData> queryList(RecordBuildingBaseDataRequest recordBuildingBaseDataRequest) {
            Condition condition = new Condition(RecordBuildingBaseData.class);
            condition.createCriteria() .andEqualTo("id", recordBuildingBaseDataRequest.getId())
                    .andEqualTo("layers",recordBuildingBaseDataRequest.getLayers())
                    .andEqualTo("builtUpArea",recordBuildingBaseDataRequest.getBuiltUpArea());
            if (recordBuildingBaseDataRequest.getBuildingName() != null) {
                condition.getOredCriteria().get(0).andLike("buildingName","%"+recordBuildingBaseDataRequest.getBuildingName()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingMode() != null) {
                condition.getOredCriteria().get(0).andLike("lightingMode","%"+recordBuildingBaseDataRequest.getLightingMode()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingSystem() != null) {
                condition.getOredCriteria().get(0).andLike("lightingSystem","%"+recordBuildingBaseDataRequest.getLightingSystem()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingLamps() != null) {
                condition.getOredCriteria().get(0).andLike("lightingLamps","%"+recordBuildingBaseDataRequest.getLightingLamps()+"%");
            }

            return this.recordBuildingBaseDataMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordBuildingBaseData> queryListPage(RecordBuildingBaseDataRequest recordBuildingBaseDataRequest, Integer pageNum, Integer pageSize) {
            Condition condition = new Condition(RecordBuildingBaseData.class);
            condition.createCriteria() .andEqualTo("id", recordBuildingBaseDataRequest.getId())
                    .andEqualTo("layers",recordBuildingBaseDataRequest.getLayers())
                    .andEqualTo("builtUpArea",recordBuildingBaseDataRequest.getBuiltUpArea());
            if (recordBuildingBaseDataRequest.getBuildingName() != null) {
                condition.getOredCriteria().get(0).andLike("buildingName","%"+recordBuildingBaseDataRequest.getBuildingName()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingMode() != null) {
                condition.getOredCriteria().get(0).andLike("lightingMode","%"+recordBuildingBaseDataRequest.getLightingMode()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingSystem() != null) {
                condition.getOredCriteria().get(0).andLike("lightingSystem","%"+recordBuildingBaseDataRequest.getLightingSystem()+"%");
            }
            if (recordBuildingBaseDataRequest.getLightingLamps() != null) {
                condition.getOredCriteria().get(0).andLike("lightingLamps","%"+recordBuildingBaseDataRequest.getLightingLamps()+"%");
            }

            PageHelper.startPage(pageNum, pageSize);
            List<RecordBuildingBaseData> dataList = this.recordBuildingBaseDataMapper.selectByCondition(condition);
            PageResult<RecordBuildingBaseData> pageList = new  PageResult<RecordBuildingBaseData>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public RecordBuildingBaseData add(RecordBuildingBaseData recordBuildingBaseData) {
            this.recordBuildingBaseDataMapper.insertUseGeneratedKeys(recordBuildingBaseData);
            return recordBuildingBaseData;
        }

        @Override
        public RecordBuildingBaseData delete(Long id) {
            this.recordBuildingBaseDataMapper.deleteByPrimaryKey(id);
            RecordBuildingBaseData recordBuildingBaseData = new RecordBuildingBaseData();
            recordBuildingBaseData.setId(id);
            return recordBuildingBaseData;
        }

        @Override
        public RecordBuildingBaseData update(RecordBuildingBaseData recordBuildingBaseData) {
            this.recordBuildingBaseDataMapper.updateByPrimaryKeySelective(recordBuildingBaseData);
            return recordBuildingBaseData;
        }

    @Override
    public List<Map<String, Object>> queryRecordBuildingBaseDataByPostPersonnel(Long id) {
        return this.recordBuildingBaseDataMapper.queryRecordBuildingBaseDataByPostPersonnel(id);
    }

}
