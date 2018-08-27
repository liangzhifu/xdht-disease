package com.xdht.disease.sys.service.impl;


import com.xdht.disease.common.annotation.ExcelImport;
import com.xdht.disease.sys.dao.record_employee_summary_excelMapper;
import com.xdht.disease.sys.model.record_employee_summary_excel;
import com.xdht.disease.sys.service.*;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import tk.mybatis.mapper.entity.Condition;




/**
 * Created by lzf on 2018/08/20.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class record_employee_summary_excelServiceImpl extends AbstractService<record_employee_summary_excel> implements record_employee_summary_excelService {

    @Autowired
    private record_employee_summary_excelMapper  recordEmployeeSummaryExcelMapper;

    @Autowired
    private RecordEmployeeSummaryService recordEmployeeSummaryService;

     public void saveRecordEmployeeSummaryExcel(Workbook workbook )throws Exception {

         Workbook wb =null;
         Sheet sheet = null;
         Row row = null;
         List<Map<String,String>> list = null;
         String cellData = null;

         String columns[] = new String[50];
         Class rese =record_employee_summary_excel.class;
         Field[] field=rese.getDeclaredFields(); //获取字段类型，返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
         int n=0;
         for(int i=4;i<field.length;i++){

             columns[n]=field[i].getName();
             n+=1;
         }
         wb = workbook;
         System.err.println(wb.getSheetName(0)+"sheet");
         if(wb != null){
             //用来存放表中数据
             list = new ArrayList<Map<String,String>>();
             //获取第一个sheet
             sheet = wb.getSheetAt(0);

             //获取最大行数
             int rownum = sheet.getPhysicalNumberOfRows();

             //获取第一行
             row = sheet.getRow(0);

             //获取最大列数
             int colnum = row.getPhysicalNumberOfCells();

             for (int i = 1; i<rownum; i++) {
                 Map<String,String> map = new LinkedHashMap<String,String>();
                 row = sheet.getRow(i);
                 if(row !=null){
                     for (int j=0;j<colnum;j++){

                         cellData = (String) getCellFormatValue(row.getCell(j));
                        if(columns[j].equals("age")||columns.equals("contactTime")){
                             cellData=cellData.substring(0, cellData.lastIndexOf("."));
                         }

                         map.put(columns[j], cellData);

                     }
                 }else{
                     break;
                 }
                 list.add(map);
                 for (Map.Entry<String,String> entry : map.entrySet()) {

                     System.out.print(entry.getKey()+":"+entry.getValue()+",");

                 }
             }

         }

         List<record_employee_summary_excel> list1= new LinkedList<>();
         //遍历解析出来的list
         for (Map<String,String> map : list) {

             try{
                 record_employee_summary_excel re=new record_employee_summary_excel();

                 Field[] fields = re.getClass().getDeclaredFields();
                 for (Field field1 : fields) {
                     if (field1.isAnnotationPresent(ExcelImport.class)) {
                         int mod = field1.getModifiers();
                         if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                             continue;
                         }
                         field1.setAccessible(true);
                         String type=field1.getAnnotatedType().getType().getTypeName();

                         switch (type) {
                             case "java.lang.String":
                                 field1.set(re, map.get(field1.getName()));
                                 break;
                             case "java.lang.Integer":
                                 field1.set(re, Integer.parseInt(map.get(field1.getName())));
                                 break;
                             case "java.util.Date":
                                 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                 field1.set(re, sdf.parse(map.get(field1.getName())));
                                 break;
                             default:
                                 break;
                         }
                     }
                 }
                 re.setInspect("0");//全部为初诊
             Calendar calendar=Calendar.getInstance();
             calendar.setTime(re.getInspectDate());
             re.setInspectYear(calendar.get(Calendar.YEAR));//检查年份
                  re.setStatus("0");
                 re.setCreateBy((long)11);
                 Date date =new Date();
                 re.setCreateDate(date);
                 re.setUpdateBy((long)11);
                 re.setUpdateDate(date);
                   list1.add(re);
             } catch (Exception e) {
                 e.printStackTrace();
         }

        }
       this.insertList(list1);

          List<record_employee_summary_excel> identityCountNull =this.recordEmployeeSummaryExcelMapper.selectIdentity();
           if(identityCountNull.size()!=0&&identityCountNull!=null){

               throw new Exception( "以下员工的身份证号不存在"+" "+ErrorReturn(identityCountNull));
           }
         this.recordEmployeeSummaryExcelMapper.updateExcelCompanyId();
         Condition condition = new Condition(record_employee_summary_excel.class);
         condition.createCriteria().andIsNull("companyId");
         List<record_employee_summary_excel> record_employee_summary_excelList =null;
                record_employee_summary_excelList = this.selectByCondition(condition);
         if(record_employee_summary_excelList!=null&&record_employee_summary_excelList.size()!=0){

             throw new Exception("以下员工的公司查询不到"+" "+ ErrorReturn(record_employee_summary_excelList));
         }
         this.recordEmployeeSummaryExcelMapper.updateExcelPostId();
         Condition condition2 = new Condition(record_employee_summary_excel.class);
         condition2.createCriteria().andIsNull("postId");
         record_employee_summary_excelList = this.selectByCondition(condition2);
         if(record_employee_summary_excelList!=null&&record_employee_summary_excelList.size()!=0){
             throw new Exception("以下员工的公司部门不到"+"  "+ErrorReturn(record_employee_summary_excelList));
         }

         this.recordEmployeeSummaryExcelMapper.updateExcelWorkTypeId();
         Condition condition3 = new Condition(record_employee_summary_excel.class);
         condition3.createCriteria().andIsNull("workTypeId");
         record_employee_summary_excelList = this.selectByCondition(condition3);
         if(record_employee_summary_excelList!=null&&record_employee_summary_excelList.size()!=0){
             throw new Exception("以下员工的工种查询不到"+"  "+ErrorReturn(record_employee_summary_excelList));
         }
         record_employee_summary_excelList=this.recordEmployeeSummaryExcelMapper.physicalExaminationInfOnce();
         if(record_employee_summary_excelList!=null&&record_employee_summary_excelList.size()!=0){
             throw new Exception("以下员工的已经录入"+"  "+ErrorReturn(record_employee_summary_excelList));
         }

         this.recordEmployeeSummaryExcelMapper.insertExcelToRecordEmployeeSummary();
         this.recordEmployeeSummaryExcelMapper.insertEmployeeContactTime();
        this.recordEmployeeSummaryExcelMapper.deleteAll();


     }

    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;

        if(cell!=null){

            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;



    }
  public static  StringBuffer ErrorReturn(List<record_employee_summary_excel> list){
        StringBuffer errorMessage =new StringBuffer();
    for(int i=0; i<list.size();i++){
         errorMessage =errorMessage.append(list.get(i).getName()+",");
   }
    return errorMessage;
  }

}
