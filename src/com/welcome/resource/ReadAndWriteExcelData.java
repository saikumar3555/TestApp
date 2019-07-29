package ExcelRealTask;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excelTask.HelperBean;

public class ReadAndWriteExcelData {
	static HashMap<String,HelperBean> map=new HashMap<String,HelperBean>();
	static String policyId=null;
	static Double bodyMassIndexImperial=0.0;
	static Integer HeightFeet=0;
	static Integer heightInches=0;
	static boolean flag=false;
	static HelperBean helperBean=null;
	static Cell cell=null;

	public static void main(String[] args) {
		
		try {
			
			 FileInputStream fis=new FileInputStream(new File("Task_Source.xlsx"));	
			 
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
			    XSSFSheet sheet=wb.getSheetAt(0);
			    
			    Iterator<Row> rowIterator =sheet.iterator();
			    while(rowIterator.hasNext()) {
			    	Row row=rowIterator.next();
			    	
			    	//get policyId from sheet
			    	//System.out.println(row.getCell(0).getNumericCellValue());
			    	
			    	policyId=row.getCell(0).getStringCellValue();
			    	flag=map.containsKey(policyId);
			    	
			    	//this if block is for key is not available in map
			    	if(!flag) {
			    		//create Bean class
			    		helperBean=new HelperBean();
			    		
			    		//set policyId into helperBean
			    		helperBean.setPolicyId(policyId);
			    		
			    		//to get column name 
			    		String columnName=row.getCell(1).getStringCellValue();
			    		
				    	if(columnName.equalsIgnoreCase("BodyMassIndexImperial")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    		 bodyMassIndexImperial=row.getCell(2).getNumericCellValue();
				    		 helperBean.setBodyMassIndexImperial(bodyMassIndexImperial);
				    		}
				    	}// bodyMassIndexImperial if
				    	
				    	
				    	if(columnName.equalsIgnoreCase("HeightFeet")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setHeightFeet((int)Math.round(d));
				    		}
				    	}// HeightFeet if
				    	
				    	if(columnName.equalsIgnoreCase("HeightInches")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setHeightInches((int)Math.round(d));
				    		}
				    	}// HeightInches if
				    	
				    	if(columnName.equalsIgnoreCase("WeightPounds")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setWeightPounds((int)Math.round(d));
				    		}
				    	}// HeightFeet if
			    		
			    		
			    	}//object not available in map--if block
			    	else {
			    		//this else block is for the object is already exist in map
			    		
			    		helperBean=map.get(policyId);
			    		String columnName=row.getCell(1).getStringCellValue();
			    		if(columnName.equalsIgnoreCase("BodyMassIndexImperial")) {
			    			cell= row.getCell(2);
				    		if(cell!=null) {
				    			if(helperBean.getBodyMassIndexImperial()==null) {
				    		 bodyMassIndexImperial=row.getCell(2).getNumericCellValue();
				    		 helperBean.setBodyMassIndexImperial(bodyMassIndexImperial);
				    			}else {
				    				helperBean.setBodyMassIndexImperial(null);
				    			}
				    		}//to check cell is empty or not
				    	}// bodyMassIndexImperial if
				    	
				    	
				    	if(columnName.equalsIgnoreCase("HeightFeet")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    			if(helperBean.getHeightFeet()==null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setHeightFeet((int)Math.round(d));
				    			}else {
				    				helperBean.setHeightFeet(null);
				    			}
				    		}//to check cell is empty or not
				    	}// HeightFeet if
				    	
				    	if(columnName.equalsIgnoreCase("HeightInches")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    			if(helperBean.getHeightInches()==null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setHeightInches((int)Math.round(d));
				    			}else {
				    				helperBean.setHeightInches(null);
				    			}
				    		}//to check cell is empty or not
				    	}// HeightInches if
				    	
				    	if(columnName.equalsIgnoreCase("WeightPounds")) {
				    		cell= row.getCell(2);
				    		if(cell!=null) {
				    			if(helperBean.getWeightPounds()==null) {
				    		 Double d=row.getCell(2).getNumericCellValue();
				    		 helperBean.setWeightPounds((int)Math.round(d));
				    			}else {
				    				helperBean.setWeightPounds(null);
				    			}
				    		}//to check cell is empty or not
				    	}// HeightFeet if
			    		
			    	}//else
			    	map.put(policyId, helperBean);
			    	
			    }//while
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		
      //to iterate map
		Set<String> keys=map.keySet();
		for(String key:keys) {
			HelperBean b=map.get(key);
			List<HelperBean> list=new ArrayList<>();
			list.add(b);
			WriteToExcelTask.writeToExcelTask(list);
			System.out.println(b);
		}
		
		
		
		
	}//main

}//class
