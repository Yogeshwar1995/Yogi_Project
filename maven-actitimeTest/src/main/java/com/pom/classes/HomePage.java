package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		@FindBy (xpath="//a[@class='content tasks']")
		private WebElement taskbutton;
		
		@FindBy (xpath="(//a[@style='border-width: 0'])[2]")
		private WebElement Reports;
		
		@FindBy (xpath="(//a[@style='border-width: 0'])[3]")
		private WebElement users;
		
		@FindBy (xpath="//a[@id='logoutLink']")
		private WebElement logout;
		
		
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void clickTaskButton()
		{
			taskbutton.click();
		}
		public void clickReportsButton()
		{
			Reports.click();
		}
		public void clickUsersButton()
		{
			users.click();
		}
		public void clickLogoutButton()
		{
			logout.click();
		}

}
