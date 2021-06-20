package com.test.classes;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pom.Utilities.Utility;
import com.pom.classes.HomePage;
import com.pom.classes.LoginPage;

import testBrowserSetup.Pojo;

public class TestClass extends Pojo {
	int testID;
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
	ExtentReports extend = new ExtentReports();
	extend.attachReporter(reporter);
	
	if (browser.equalsIgnoreCase("Chrome"))
	{
		driver = openChromeBrowser();
	}
	else if (browser.equalsIgnoreCase("Firefox"))
	{
		driver = openFirefoxBrowser();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@BeforeClass
	public void beforeClass() {
		driver.get("http://localhost/login.do");
	}
	//         Pre-condition
	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage(driver);
		loginPage.sendUsername();
		loginPage.sendPassword();
		loginPage.clickOnLogin();
	}
    
	//             Test step-1
	@Test
	public void verifyTaskLink() throws InterruptedException {
		testID = 101;
		Thread.sleep(2000);
		System.out.println("Verify the Task button");
		homePage = new HomePage (driver);
		homePage.clickTaskButton();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
	}
	//                  Test step-2
	@Test	
	public void verifyReportsLink() throws InterruptedException {
		testID = 102;
		Thread.sleep(2000);
		System.out.println("Verify the Reports button");
		homePage = new HomePage (driver);
		homePage.clickReportsButton();
		String url = driver.getCurrentUrl();	
		Assert.assertEquals(url, "http://localhost/reports/reports.do");

	}
	//                      Test step-3
	@Test
	public void verifyUsersLink() throws InterruptedException {
		testID = 103;
		Thread.sleep(2000);
		System.out.println("Verify the Users button");
		homePage = new HomePage (driver);
		homePage.clickUsersButton();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();	
		Assert.assertEquals(url, "http://localhost/administration/userlist.do");
	}
//	@Test
//	public void ExcelData() throws EncryptedDocumentException, IOException {
//		try
//		{
//		System.out.println("Fetch the Data from Excel Sheet");
//		Utility excel = new Utility();
//		excel.ExcelDataFetch();
//		}
//		catch(IllegalStateException e)
//		{
//			System.out.println("IllegalStateException");
//		}	
//	}
	//                     Post-condition
	@AfterMethod
	public void logoutActiTime(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.takeScreenshot(driver, testID);
		}
		Thread.sleep(2000);
		homePage = new HomePage (driver);
		homePage.clickLogoutButton();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
}
