package com.xdht.disease.sys.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.sys.model.SysCompanyOffice;

import java.util.List;
import java.util.Map;

public interface SysCompanyOfficeMapper extends Mapper<SysCompanyOffice> {

    /**
     * 删除子节点
     * @param map 条件
     */
    public void deleteChild(Map<String, Object> map);

}