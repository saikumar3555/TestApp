package excelTask;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Excel.Employee;

public class TestExcel {
	
	public static void main(String[] args) {
		//List<Employee> list=new ArrayList<Employee>();
		HashMap<Double,Employee> map=new HashMap<Double,Employee>();
		
		
		try {
		 FileInputStream fis=new FileInputStream(new File("Employee_Source.xlsx"));	
		 
		 XSSFWorkbook wb=new XSSFWorkbook(fis);
		    XSSFSheet sheet=wb.getSheetAt(0);
		    
		    Iterator<Row> rowIterator =sheet.iterator();
		    //rowIterator.next();
		    
		    while(rowIterator.hasNext()) {
		    	
		    	Row row=rowIterator.next();
		    	
		    	
		    	double verifyEid=row.getCell(0).getNumericCellValue();
		    	//System.out.println("verifyEid" +verifyEid);
		    	boolean flag=map.containsKey(verifyEid);
		    	
		    	if(!flag) {
		    		Employee emp=new Employee();
		    	double eid=row.getCell(0).getNumericCellValue();
		    	emp.setEid((int)Math.round(eid));
		    	
		    	String columnName=row.getCell(1).getStringCellValue();
		    	if(columnName.equalsIgnoreCase("NAME")) {
		    		String name=row.getCell(2).getStringCellValue();
		    		emp.setEname(name);
		    	}//name if
		    	
		    	
		    	if(columnName.equalsIgnoreCase("DESG")) {
		    		String desg=row.getCell(2).getStringCellValue();
		    		emp.setDesg(desg);
		    	}//name if
		    	
		    	if(columnName.equalsIgnoreCase("SALARY")) {
		    		double salary=row.getCell(2).getNumericCellValue();
		    		emp.setSalary(salary);
		    	}//name if
		    	
		  //list.add(emp);
		    	map.put(eid, emp);
		    
		    }//if outer
		    	 else {
				    	//key exist
				    Employee emp=map.get(verifyEid);
				    System.out.println(emp+"   ::emp2");
				    
				    String columnName=row.getCell(1).getStringCellValue();
			    	if(columnName.equalsIgnoreCase("NAME")) {
			    		String name=row.getCell(2).getStringCellValue();
			    		emp.setEname(name);
			    	}//name if
			    	
			    	
			    	if(columnName.equalsIgnoreCase("DESG")) {
			    		String desg=row.getCell(2).getStringCellValue();
			    		emp.setDesg(desg);
			    	}//name if
			    	
			    	if(columnName.equalsIgnoreCase("SALARY")) {
			    		double salary=row.getCell(2).getNumericCellValue();
			    		emp.setSalary(salary);
			    	}//name if
				    
				    System.out.println("Key Exist"+emp);
				    	
				    	
				    	
				    }//else
		    
		    }//while
		   
		    
		    
		    
		    
		    
		}catch (Exception e) {
e.printStackTrace();
}//catch
	 	Set<Double> keys=map.keySet();
    	for(Double key:keys) {
    		System.out.println(map.get(key));
    	}
	}//main

}//class
