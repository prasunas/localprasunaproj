package automation;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotCapturing {

static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   driver.get("file:///D:/Selenium/docs/sample.html");
   File fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(fs, new File("D:/selenium/kony.png"));
   
	}

}

