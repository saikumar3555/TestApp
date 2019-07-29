package ExcelRealTask;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import excelTask.HelperBean;

public class WriteToExcelTask {
	static int rowNum = 0;
	static int cellNum=0;
	static HSSFWorkbook book=null;
	static FileOutputStream fos=null;

	public static void writeToExcelTask(List<HelperBean> listOFHelperBeans) {

		// create file output stream
		try {
			FileOutputStream fos = new FileOutputStream("Task_Destination6.xls");

			// create workbook
			 book = new HSSFWorkbook();

			// create sheet
			Sheet sheet = book.createSheet();
			listOFHelperBeans.forEach(eachBean -> {

				 System.out.println("eachBean ::: "+eachBean);
				// create row for each time
				Row row = sheet.createRow(rowNum++);
				System.out.println(rowNum);
				
				
				//to add each book property values to list
				List<String> list = new ArrayList();
				list.add(eachBean.getPolicyId());
				list.add(String.valueOf(eachBean.getBodyMassIndexImperial()));
				list.add(String.valueOf(eachBean.getHeightFeet()));
				list.add(String.valueOf(eachBean.getHeightInches()));
				list.add(String.valueOf(eachBean.getWeightPounds()));
                
				for (String value : list) {
					Cell cell = row.createCell(cellNum++);
					cell.setCellValue(value);
					
				}
				
                cellNum=0;
				
				/*row.createCell(0).setCellValue(eachBean.getPolicyId());
				row.createCell(1).setCellValue(String.valueOf(eachBean.getBodyMassIndexImperial()));
				row.createCell(2).setCellValue(String.valueOf(eachBean.getHeightFeet()));
				row.createCell(3).setCellValue(String.valueOf(eachBean.getHeightInches()));
				row.createCell(4).setCellValue(String.valueOf(eachBean.getWeightPounds()));*/

				//rowNum++;
				

			});

			
			book.write(fos);
			book.close();
			fos.close();
		} // try
		catch (Exception e) {
			e.printStackTrace();
		} // catch
		
		

	}// main

}// class
