package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {

	public static WebDriver openChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // Up Casting
		
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "browsers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}
	
	
	
}
