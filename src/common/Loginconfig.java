package common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Loginconfig {
	
	public static WebDriver driver;
  @Test
  public void f() {
	  
  }
  @BeforeSuite
  public void beforeSuite() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://opensource-demo.orangehrmlive.com/");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  {
	  driver.close();
	  
	}
  }

}
