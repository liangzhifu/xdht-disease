package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.record_employee_summary_excel;
import com.xdht.disease.common.core.Service;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * Created by lzf on 2018/08/20.
 */
public interface record_employee_summary_excelService extends Service<record_employee_summary_excel> {
    public void saveRecordEmployeeSummaryExcel(Workbook workbook )throws Exception;
}
