package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.annotation.ExcelImport;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.util.Md5Utils;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.SysEmployeeMapper;
import com.xdht.disease.sys.model.*;
import com.xdht.disease.sys.service.*;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Created by lzf on 2018/06/01.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysEmployeeServiceImpl extends AbstractService<SysEmployee> implements SysEmployeeService {

    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;

    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;

    @Autowired
    private SysEmployeeJobService sysEmployeeJobService;

    @Autowired
    private SysCompanyOfficeService sysCompanyOfficeService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

    @Autowired
    private SysEmployeeExcelService sysEmployeeExcelService;

    @Override
    public PageResult<Map<String, Object>> querySysEmpPage(SysEmployeeRequest sysEmployeeRequest) {
        Integer pageNumber = sysEmployeeRequest.getPageNumber();
        Integer pageSize = sysEmployeeRequest.getPageSize();
        Integer start = (pageNumber - 1) * pageSize;
        sysEmployeeRequest.setStart(start);
        List<Map<String, Object>> dataList = this.sysEmployeeMapper.selectCompanyEmployeeListByRequest(sysEmployeeRequest);
        Integer total = this.sysEmployeeMapper.selectCompanyEmployeeCountByRequest(sysEmployeeRequest);
        PageResult<Map<String, Object>> pageList = new PageResult<>();
        pageList.setDataList(dataList);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public List<SysEmployee> queryCompanyEmployeeList(SysEmployeeRequest sysEmployeeRequest) {
        Condition condition = new Condition(SysEmployee.class);
        condition.createCriteria().andEqualTo("officeId", sysEmployeeRequest.getOfficeId());
        if (sysEmployeeRequest.getEmpName() != null && !"".equals(sysEmployeeRequest.getEmpName())) {
            condition.getOredCriteria().get(0).andLike("empName", "%" + sysEmployeeRequest.getEmpName() + "%");
        }
        condition.setOrderByClause("id desc");
        return this.selectByCondition(condition);
    }

    @Override
    public void addEmployee(SysEmployeeResponse sysEmployeeResponse) throws Exception {
        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        Condition condition = new Condition(SysEmployee.class);
        condition.createCriteria().andEqualTo("empIdentityNumber", sysEmployee.getEmpIdentityNumber())
                .andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        int num = this.selectCountByCondition(condition);
        if (num > 0) {
            throw new Exception("该身份证已经存在");
        }
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        this.insertUseGeneratedKeys(sysEmployee);
        // 同时添加数据到用户表中
        SysUser sysUser = new SysUser();
        sysUser.setUserName(sysEmployee.getEmpName());
        sysUser.setSex(sysEmployee.getEmpSex());
        sysUser.setMgrType(SysEnum.MgrTypeEnum.MGR_TYPE_NOT.getCode());
        sysUser.setLoginCode(sysEmployee.getEmpIdentityNumber());
        sysUser.setPassword(Md5Utils.md5("111111"));
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        sysUser.setEmpId(sysEmployee.getId());
        sysUser.setAvatar(sysEmployee.getImageName());
        this.sysUserService.insertUseGeneratedKeys(sysUser);
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        if (sysEmployeeCaseList != null && sysEmployeeCaseList.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
                sysEmployeeCase.setEmployeeId(sysEmployee.getId());
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeCaseService.insertList(sysEmployeeCaseList);
        }

        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseaseList != null && sysEmployeeDiseaseList.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
                sysEmployeeDisease.setEmployeeId(sysEmployee.getId());
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeDiseaseService.insertList(sysEmployeeDiseaseList);
        }

        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        if (sysEmployeeJobList != null && sysEmployeeJobList.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
                sysEmployeeJob.setEmployeeId(sysEmployee.getId());
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            sysEmployeeJobService.insertList(sysEmployeeJobList);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        SysEmployeeResponse employeeDetail = getEmployeeDetail(id);
        SysEmployee sysEmployee = employeeDetail.getSysEmployee();
        sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.updateByPrimaryKeySelective(sysEmployee);
        // 删除用户中关联的职工信息
        Long empId = sysEmployee.getId();
        SysUser sysUser = new SysUser();
        sysUser.setEmpId(empId);
        sysUser = this.sysUserService.selectOne(sysUser);
        sysUser.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
        this.sysUserService.updateByPrimaryKeySelective(sysUser);

        List<SysEmployeeCase> sysEmployeeCases = employeeDetail.getSysEmployeeCaseList();
        if (sysEmployeeCases != null && sysEmployeeCases.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeCaseService.updateByPrimaryKeySelective(sysEmployeeCase);
            }
        }

        List<SysEmployeeDisease> sysEmployeeDiseases = employeeDetail.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseases != null && sysEmployeeDiseases.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeDiseaseService.updateByPrimaryKeySelective(sysEmployeeDisease);
            }
        }

        List<SysEmployeeJob> sysEmployeeJobs = employeeDetail.getSysEmployeeJobList();
        if (sysEmployeeJobs != null && sysEmployeeJobs.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeJobService.updateByPrimaryKeySelective(sysEmployeeJob);
            }
        }
    }

    /**
     * 修改
     *
     * @param sysEmployeeResponse
     */
    @Override
    public void updateEmployee(SysEmployeeResponse sysEmployeeResponse) {

        SysEmployee sysEmployee = sysEmployeeResponse.getSysEmployee();
        Long sysEmployeeId = sysEmployee.getId();
        this.updateByPrimaryKeySelective(sysEmployee);
        // sysEmployeeId是user表中对应的职工关联id
        // 修改user表对应的职工信息
        SysUser sysUser = new SysUser();
        sysUser.setEmpId(sysEmployeeId);
        sysUser = this.sysUserService.selectOne(sysUser);
        if (sysUser != null) {
            sysUser.setUserName(sysEmployee.getEmpName());
            sysUser.setSex(sysEmployee.getEmpSex());
            sysUser.setLoginCode(sysEmployee.getEmpIdentityNumber());
            sysUser.setAvatar(sysEmployee.getImageName());
            this.sysUserService.updateByPrimaryKeySelective(sysUser);
        }

        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseService.selectByCondition(condition);
        if (sysEmployeeCases != null && sysEmployeeCases.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCases) {
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeCaseService.updateByPrimaryKeySelective(sysEmployeeCase);
            }
        }
        List<SysEmployeeCase> sysEmployeeCaseList = sysEmployeeResponse.getSysEmployeeCaseList();
        if (sysEmployeeCaseList != null && sysEmployeeCaseList.size() > 0) {
            for (SysEmployeeCase sysEmployeeCase : sysEmployeeCaseList) {
                sysEmployeeCase.setEmployeeId(sysEmployeeId);
                sysEmployeeCase.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeCaseService.insertList(sysEmployeeCaseList);
        }

        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseService.selectByCondition(condition1);
        if (sysEmployeeDiseases != null && sysEmployeeDiseases.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseases) {
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeDiseaseService.updateByPrimaryKeySelective(sysEmployeeDisease);
            }
        }
        List<SysEmployeeDisease> sysEmployeeDiseaseList = sysEmployeeResponse.getSysEmployeeDiseaseList();
        if (sysEmployeeDiseaseList != null && sysEmployeeDiseaseList.size() > 0) {
            for (SysEmployeeDisease sysEmployeeDisease : sysEmployeeDiseaseList) {
                sysEmployeeDisease.setEmployeeId(sysEmployeeId);
                sysEmployeeDisease.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeDiseaseService.insertList(sysEmployeeDiseaseList);
        }

        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", sysEmployeeId).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobService.selectByCondition(condition1);
        if (sysEmployeeJobs != null && sysEmployeeJobs.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobs) {
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_DELETE.getCode());
                this.sysEmployeeJobService.updateByPrimaryKeySelective(sysEmployeeJob);
            }
        }
        List<SysEmployeeJob> sysEmployeeJobList = sysEmployeeResponse.getSysEmployeeJobList();
        if (sysEmployeeJobList != null && sysEmployeeJobList.size() > 0) {
            for (SysEmployeeJob sysEmployeeJob : sysEmployeeJobList) {
                sysEmployeeJob.setEmployeeId(sysEmployeeId);
                sysEmployeeJob.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            }
            this.sysEmployeeJobService.insertList(sysEmployeeJobList);
        }
    }

    @Override
    public SysEmployeeResponse getEmployeeDetail(Long id) {
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        SysEmployee sysEmployee = this.selectByPrimaryKey(id);
        Long officeId = sysEmployee.getOfficeId();
        SysCompanyOffice sysCompanyOffice = new SysCompanyOffice();
        if (officeId != null) {
            sysCompanyOffice = this.sysCompanyOfficeService.selectByPrimaryKey(officeId);
            sysEmployeeResponse.setSysCompanyOffice(sysCompanyOffice);
        } else {
            sysEmployeeResponse.setSysCompanyOffice(sysCompanyOffice);
        }
        sysEmployeeResponse.setSysEmployee(sysEmployee);

        Condition condition = new Condition(SysEmployeeCase.class);
        condition.createCriteria().andEqualTo("employeeId", id).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeCase> sysEmployeeCases = this.sysEmployeeCaseService.selectByCondition(condition);
        sysEmployeeResponse.setSysEmployeeCaseList(sysEmployeeCases);

        Condition condition1 = new Condition(SysEmployeeDisease.class);
        condition1.createCriteria().andEqualTo("employeeId", id).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeDisease> sysEmployeeDiseases = this.sysEmployeeDiseaseService.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeDiseaseList(sysEmployeeDiseases);

        Condition condition2 = new Condition(SysEmployeeJob.class);
        condition2.createCriteria().andEqualTo("employeeId", id).andEqualTo("status", SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        List<SysEmployeeJob> sysEmployeeJobs = this.sysEmployeeJobService.selectByCondition(condition1);
        sysEmployeeResponse.setSysEmployeeJobList(sysEmployeeJobs);
        return sysEmployeeResponse;
    }

    @Override
    public void saveEmployeeExcel(Workbook workbook) throws Exception {
        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, Object>> list = null;
        Object cellData = null;

        String columns[] = new String[50];
        Class rese = SysEmployeeExcel.class;
        Field[] field = rese.getDeclaredFields(); //获取字段类型，返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
        int n = 0;
        for (int i = 0; i < field.length; i++) {
            Field field1 = field[i];
            if (field1.isAnnotationPresent(ExcelImport.class)) {
                columns[n] = field[i].getName();
                n += 1;
            }
        }
        wb = workbook;

        if (wb != null) {
            //用来存放表中数据
            list = new ArrayList<>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();

            for (int i = 1; i < rownum; i++) {
                Map<String, Object> map = new LinkedHashMap<>();
                row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < colnum; j++) {
                        cellData = getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                } else {
                    break;
                }
                list.add(map);
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
                }
            }
        }

        List<SysEmployeeExcel> list1 = new LinkedList<>();
        //遍历解析出来的list
        for (Map<String, Object> map : list) {

            try {
                SysEmployeeExcel sysEmployeeExcel = new SysEmployeeExcel();

                Field[] fields = sysEmployeeExcel.getClass().getDeclaredFields();
                for (Field field1 : fields) {
                    if (field1.isAnnotationPresent(ExcelImport.class)) {
                        int mod = field1.getModifiers();
                        if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                            continue;
                        }
                        field1.setAccessible(true);
                        String type = field1.getAnnotatedType().getType().getTypeName();

                        switch (type) {
                            case "java.lang.String":
                                field1.set(sysEmployeeExcel, map.get(field1.getName()));
                                break;
                            case "java.lang.Integer":
                                field1.set(sysEmployeeExcel, Double.valueOf((String)map.get(field1.getName())).intValue());
                                break;
                            case "java.util.Date":
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                field1.set(sysEmployeeExcel, sdf.parse((String)map.get(field1.getName())));
                                break;
                            default:
                                break;
                        }
                    }
                }
                list1.add(sysEmployeeExcel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.sysEmployeeExcelService.insertList(list1);
        this.sysEmployeeExcelService.updateCheckSysEmployeeExcel();
        List<SysEmployeeExcel> employeeExcelList = this.sysEmployeeExcelService.selectAll();
        if (employeeExcelList != null && !employeeExcelList.isEmpty()) {
            for (SysEmployeeExcel sysEmployeeExcel : employeeExcelList) {
                SysEmployee sysEmployee = new SysEmployee();
                sysEmployee.setOfficeId(sysEmployeeExcel.getWorkTypeId());
                sysEmployee.setEmpName(sysEmployeeExcel.getEmpName());
                sysEmployee.setEmpSex(sysEmployeeExcel.getEmpSex());
                sysEmployee.setEmpNative(sysEmployeeExcel.getEmpNative());
                sysEmployee.setEmpMarriage(sysEmployeeExcel.getEmpMarriage());
                sysEmployee.setEmpEducation(sysEmployeeExcel.getEmpEducation());
                sysEmployee.setEmpHobby(sysEmployeeExcel.getEmpHobby());
                sysEmployee.setContactTime(sysEmployeeExcel.getContactTime());
                sysEmployee.setEmpWorkDate(sysEmployeeExcel.getEmpWorkDate());
                sysEmployee.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                sysEmployee.setEmpIdentityNumber(sysEmployeeExcel.getEmpIdentityNumber());
                this.insertUseGeneratedKeys(sysEmployee);

                SysUser sysUser = new SysUser();
                sysUser.setUserName(sysEmployee.getEmpName());
                sysUser.setSex(sysEmployee.getEmpSex());
                sysUser.setMgrType(SysEnum.MgrTypeEnum.MGR_TYPE_NOT.getCode());
                sysUser.setLoginCode(sysEmployee.getEmpIdentityNumber());
                sysUser.setPassword(Md5Utils.md5("111111"));
                sysUser.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
                sysUser.setEmpId(sysEmployee.getId());
                sysUser.setAvatar(sysEmployee.getImageName());
                this.sysUserService.insertUseGeneratedKeys(sysUser);
            }
        }

        this.sysEmployeeExcelService.updateClearSysEmployeeExcel();
    }

    private Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case FORMULA:
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellValue = sdf.format(cell.getDateCellValue());
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;

                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

}
