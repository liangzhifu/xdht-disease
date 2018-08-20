package com.xdht.disease.sys.service.impl;


import com.xdht.disease.sys.dao.record_employee_summary_excelMapper;
import com.xdht.disease.sys.model.record_employee_summary_excel;
import com.xdht.disease.sys.service.record_employee_summary_excelService;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Created by lzf on 2018/08/20.
 */
@Service
@Transactional
public class record_employee_summary_excelServiceImpl extends AbstractService<record_employee_summary_excel> implements record_employee_summary_excelService {

    @Autowired
    private record_employee_summary_excelMapper  recordEmployeeSummaryExcelMapper;

     public void saveRecordEmployeeSummaryExcel( ) {

         Workbook wb =null;
         Sheet sheet = null;
         Row row = null;
         List<Map<String,String>> list = null;
         String cellData = null;
         String filePath = "C:\\新建文件夹\\test.xlsx";
         String columns[] = new String[50];
         Class rese =record_employee_summary_excel.class;
         Field[] field=rese.getDeclaredFields(); //获取字段类型，返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
         int n=0;
         for(int i=4;i<field.length;i++){

             columns[n]=field[i].getName();
             n+=1;
         }
         wb = readExcel(filePath);
         System.err.println(wb.getSheetName(0)+"sheet");
         if(wb != null){
             //用来存放表中数据
             list = new ArrayList<Map<String,String>>();
             //获取第一个sheet
             sheet = wb.getSheetAt(0);
             System.err.println("获取第一个sheet"+sheet);
             //获取最大行数
             int rownum = sheet.getPhysicalNumberOfRows();
             System.err.println("获取最大行数"+rownum);
             //获取第一行
             row = sheet.getRow(0);
             System.err.println("获取第一行数"+row.toString());
             //获取最大列数
             int colnum = row.getPhysicalNumberOfCells();
             System.err.println("获取最大列数"+colnum);
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
             }
         }



               List<record_employee_summary_excel> list1= new LinkedList<>();
         //遍历解析出来的list
         for (Map<String,String> map : list) {

             try{
                 record_employee_summary_excel re=new record_employee_summary_excel();

                 Field[] fields = re.getClass().getDeclaredFields();
                 for (Field field1 : fields) {
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
                         default:
                             break;
                     }

                 }
                 System.out.println(re.getCompany()+ re.getContactTime()+"..................");
                 System.out.println(re.getName()+ re.getAge()+".............");
                   list1.add(re);
             } catch (Exception e) {
                 e.printStackTrace();
         }


             for (Entry<String,String> entry : map.entrySet()) {

                 System.out.print(entry.getKey()+":"+entry.getValue()+",");

             }
             System.out.println();
         }
         this.insertList(list1);

     }
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));

        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
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

}
