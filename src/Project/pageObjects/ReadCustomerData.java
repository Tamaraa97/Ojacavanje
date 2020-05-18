package Project.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadCustomerData  {
	

		private static XSSFWorkbook wb;
		private static XSSFSheet sheet;
		private static FileInputStream fis;
		
		public static void findExcelSheet() {
			try {
				fis = new FileInputStream("ojacproj.xlsx");
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheetAt(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String id(int i) {
			DataFormatter formatter = new DataFormatter(); 
			Cell cell = sheet.getRow(i).getCell(0);
			String id= formatter.formatCellValue(cell);
			return id;
		}
		
		
		public static String UserName(int i) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(1);
			return cell.getStringCellValue();
		}
		

		public static String EMail(int i) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(2);
			return cell.getStringCellValue();
		}
		
		public static String Password(int i) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(3);
			return cell.getStringCellValue();
		}
		
		public static String ConfPassword(int i) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(4);
			return cell.getStringCellValue();
		}
	

		public static int getRowNumber() {
			try {
				return sheet.getLastRowNum() + 1;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Error.");
				return -1;
			}
		}
		
		public static String generateS() {
			int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		 
		    return generatedString;
		}
		

		public static void inputUSERNAME(WebDriver driver, String data) {
			WebElement element1 = driver.findElement(Registration.regUsern);
			element1.sendKeys(data);
		}
		
		
		
		public static void closeFis() {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}

	




	
	


