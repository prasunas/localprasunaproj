package automation;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumAutomation.ExcelInteraction;

public class DataDriving {
static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
   ArrayList<String> a1=ExcelInteraction.readFromExcel("D:\\Selenium\\docs\\prasuna.xls", "sheet1");
   for(int i=0;i<a1.size();i++)

   {
	   WebElement search=driver.findElement(By.name("serach"));
	   WebElement button=driver.findElement(By.xpath("//div[@id='serach']//button"));
	   search.clear();
	   search.sendKeys(a1.get(i));
	   button.click();
   }
	}

}
