package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		
		@FindBy (xpath="//input[@id='username']")
		private WebElement user;
		
		@FindBy (xpath="//input[@name='pwd']")
		private WebElement password;
		
		@FindBy (xpath="//div[text()='Login ']")
		private WebElement login;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void sendUsername(){
			user.sendKeys("admin");
		}
		public void sendPassword(){ 
			password.sendKeys("manager");
		}
		public void clickOnLogin(){
			login.click();
		}


}
