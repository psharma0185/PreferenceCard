package selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Excel_read {

	public Excel_read() {
		
	}

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Praveen Sharma\\Downloads\\import-template (21).xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook Workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet2=Workbook.getSheetAt(0);
		String data0=sheet2.getRow(0).getCell(0).getStringCellValue();
		System.out.println("data form excel is: "+data0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//Create an object of File class to open xlsx file
//        File file = new File("C:\\Users\\Praveen Sharma\\Downloads\\import-template (21).xlsx");
//        
//        //Create an object of FileInputStream class to read excel file
//        FileInputStream inputStream = new FileInputStream(file);
//        
//        //Creating workbook instance that refers to .xls file
//        //HSSFWorkbook wb=new HSSFWorkbook(inputStream);
//        
//        //Creating a Sheet object using the sheet Name
//        HSSFSheet sheet=wb.getSheet("Facility Master");
//        
//        //Create a row object to retrieve row at index 1
//        HSSFRow row2=sheet.getRow(1);
//        
//        //Create a cell object to retreive cell at index 5
//        //HSSFCell cell=row2.getCell(5);
//        
//        //Get the address in a variable
//        String Facility_name = Cell.getstra
//        
//        //Printing the address
//        System.out.println("Facility_name :"+ Facility_name);
		
		
		
		
		
//		File Src=new File("D:\\Data\\Rishi Sir\\Domain link no.xlsx");
//		FileInputStream fis=new FileInputStream(Src);
//		XSSFWorkbook Workbook=new XSSFWorkbook(fis);
//		XSSFSheet sheet1=Workbook.getSheetAt(0);
//		String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
//		System.out.println("data form excel is: "+data0);
				
				
				
		

	}

}
