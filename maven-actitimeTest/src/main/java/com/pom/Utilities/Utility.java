package com.pom.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void takeScreenshot(WebDriver driver , int testID) throws IOException {
	
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest = new File ("test-output"+File.separator+"testScreenshots"+File.separator+"Test_"+testID+"Date and Time"+".jpg");
	
	FileHandler.copy(source, dest);
	
	}
	
//	public static void ExcelDataFetch() throws EncryptedDocumentException, IOException {
//		
//	String path = "E:\\Testing\\Excl sheet.xlsx";
//	
//	FileInputStream file = new FileInputStream(path);
//	
//	Workbook a = WorkbookFactory.create(file);
//	
//	Sheet b = a.getSheet("Sheet1");
//		
//	for (int i=0; i<=4; i++)
	
//	{
//		for (int j=0; j<=1;j++)
//		{
//		System.out.print(b.getRow(i).getCell(j).getNumericCellValue()+ "	");
//		
//		}
//		
//		System.out.println();	
//	}
//	}
}

