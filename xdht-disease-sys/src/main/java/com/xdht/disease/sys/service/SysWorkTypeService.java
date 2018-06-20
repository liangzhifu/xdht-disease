package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.model.SysWorkType;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeCompanyRequest;
import com.xdht.disease.sys.vo.request.SysWorkTypeRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/20.
 */
public interface SysWorkTypeService extends Service<SysWorkType> {
    /**
     * 查询员工列表
     * @param sysWorkTypeRequest 查询条件
     * @return 返回结果
     */
    public List<SysWorkType> querySysWorkTypeList(SysWorkTypeRequest sysWorkTypeRequest);

}
