package automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	static WebDriver driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
   driver.get("file:///D:/Selenium/docs/sample.html");
   String newBrowser="";
   String currentBrowser=driver.getWindowHandle();
   driver.findElement(By.linkText("Yahoo")).click();
   Set<String>allBrowser=driver.getWindowHandles();
   //iterate overset--it will take one by one and compare with currnt browser.
   for(String s:allBrowser)
   {
	   if(!s.equals(currentBrowser))
			   {
		   
		         newBrowser=s;
		         break;
			   }
		   
		   
	   }
   
   driver.switchTo().window(newBrowser);
   System.out.println("new title "+driver.getTitle());
   
   }
   
		

	}


