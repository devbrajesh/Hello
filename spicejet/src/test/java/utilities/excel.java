package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class excel {
	
		@SuppressWarnings("resource")
		public void putDataExcel(WebDriver driver) throws IOException 
		{
	        XSSFWorkbook wb = new XSSFWorkbook();
	        XSSFSheet sheet = wb.createSheet("Sheet");
	        // Create a row and put some cells in it. Rows are 0 based.
	        XSSFRow row1 = sheet.createRow(0);	        // Create a cell
	        row1.createCell(0).setCellValue("CJB");	//Put value in cell 1
	        row1.createCell(1).setCellValue("MAA");	//Put value in cell 2
	        FileOutputStream fileOut = new FileOutputStream("data.xlsx"); 
	        // Write the output to a file data.xlsx
	        wb.write(fileOut);
	        fileOut.close(); //close file
	      }
		
		@SuppressWarnings("resource")
		public static String getDataExcel1() throws IOException
		{
		FileInputStream f = new FileInputStream("data.xlsx"); //read the input from file data.xlsx
		XSSFWorkbook wb = new XSSFWorkbook(f);
		//getting the sheet
		XSSFSheet sh = wb.getSheet("Sheet");
		String value= sh.getRow(0).getCell(0).getStringCellValue(); //storing the data from the excel sheet in value
		return value;
		}
		@SuppressWarnings("resource")
		public static String getDataExcel2() throws IOException
		{
		FileInputStream f = new FileInputStream("data.xlsx"); //read the input from file data.xlsx
		XSSFWorkbook wb = new XSSFWorkbook(f);
		//getting the sheet
		XSSFSheet sh = wb.getSheet("Sheet");
		String value1= sh.getRow(0).getCell(1).getStringCellValue(); //storing the data from the excel sheet in value
		return value1;
		}
}