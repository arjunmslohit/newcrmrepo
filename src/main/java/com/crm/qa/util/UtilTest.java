package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.BaseTest;

public class UtilTest extends BaseTest {
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICITLY_WAIT=20;
	
	
	public static String TEST_DATA_PATH="C:\\Users\\DELL\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\testdata\\pomData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchtoframe() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	
	public static Object[][] getTestData(String sheetname){
		FileInputStream file=null;
		
		
		try {
			file=new FileInputStream(TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			try {
				book=WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}
	
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
