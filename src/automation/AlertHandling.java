package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	static WebDriver driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   System.setProperty("webdriver.chrome.driver", "D:\\chrome");
   driver=new ChromeDriver();
   driver.get("file:///D:/sELENIUM/DOCS/sample.html");
	   driver.findElement(By.id("button1")).click();
   driver.switchTo().alert().accept();
   driver.findElement(By.id("username")).sendKeys("test");
   
   
   
   
	}

}
