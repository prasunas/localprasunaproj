package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {

		static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\Automation_Training\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		//driver1 = new FirefoxDriver();
		driver.get("https://demo.opencart.com");
		String sTitle = driver.getTitle();
		System.out.println("Title is "+sTitle);
		if(sTitle.equalsIgnoreCase("Your Store"))
		{
			System.out.println("Page load verification Passed");
		}
		else {
			System.out.println("Page load verification Failed");
		}
		String searchword = "iphone";
		String qty = "3";
		driver.findElement(By.name("search")).sendKeys(searchword);
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		new Select(driver.findElement(By.name("category_id"))).selectByIndex(3);
		driver.findElement(By.name("sub_category"));
		driver.findElement(By.xpath("//img[@title='iPhone']")).click();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("3");
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]"), "iPhone"));
		String addedProduct = driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]")).getText();
		String addedqty = driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[3]")).getText();
		System.out.println(addedProduct);
		if(searchword.equalsIgnoreCase(addedProduct)) {
			System.out.println("Added product is matching");
			}
		else {
			System.out.println("Added product is not matching, Expected : "+searchword+" Actual : "+addedProduct);
		}
		if(addedqty.contains(qty))
		{
			System.out.println("Added Qty is matching");
		}
		else {
			System.out.println("Added Qty is not matching, Expected : "+qty+" Actual : "+addedqty);
		}
	driver.findElement(By.linkText("Checkout")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]/h4/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("input-coupon")).sendKeys("ZOMATO30");
	driver.findElement(By.id("button-coupon")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//[@id='accordion']/div[2]/div[1]/h4/a")).click();
	new Select(driver.findElement(By.name("country_id"))).selectByVisibleText("India");;
	Thread.sleep(1000);
	new Select(driver.findElement(By.name("zone_id"))).selectByVisibleText("Andhra Pradesh");
	Thread.sleep(1000);
	driver.findElement(By.name("postcode")).sendKeys("533105");
	driver.findElement(By.id("button-quote")).click();
	
	}

}


