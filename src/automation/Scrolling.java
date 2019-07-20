package automation;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Scrolling {
static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
   driver.get("https://WWW.w3schools.com/html/html_tables.asp");
   JavascriptExecutor js=(JavascriptExecutor)driver;
   //if we have vertical or horizontal then give right side also
   
   //js.executeScript("window.scrollBy(0,1000)","(0,1000)");
   js.executeScript("window.scrollBy(0,1000)","");
   Thread.sleep(1000);
   driver.close();

	}

}
