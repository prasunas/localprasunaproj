package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/bested_frames");
//frame identification if name is not given
driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
//frame identification directly if name is given
driver.switchTo().frame("frame-middle");
String sDate=driver.findElement(By.id("content")).getText();
System.out.println(sDate);


	}

}
