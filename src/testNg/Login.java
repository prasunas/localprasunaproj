package testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login {
	static WebDriver driver;
	String searchword;
	String sQty;
	
 	
  @Test(groups={"init"},priority=1)
  
  public void searchFunctionality()
  {
	  String sTitle = driver.getTitle();
		System.out.println("Title is "+sTitle);
		Assert.assertEquals(sTitle, "Your Store");
		searchword = "iphone";
		sQty = "3";
		driver.findElement(By.name("search")).sendKeys(searchword);
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		new Select(driver.findElement(By.name("category_id"))).selectByIndex(3);
		driver.findElement(By.name("sub_category")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//img[@title='iPhone']")).isDisplayed(),true);
		
  }
  @Test(groups={"smoke", "regression"},priority=2)
  public void cartverification() {
	  driver.findElement(By.xpath("//img[@title='iPhone']")).click();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("3");
		driver.findElement(By.id("button-cart")).click();
		driver.findElement(By.id("cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]"), "iPhone"));
		String addedProduct = driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[2]")).getText();
		String addedqty = driver.findElement(By.xpath("//div[@id='cart']/ul/li[1]/table//tr/td[3]")).getText();
		
		System.out.println(addedProduct);
		Assert.assertEquals(addedProduct.toLowerCase(), searchword.toLowerCase());
		Assert.assertEquals(addedqty.contains(sQty),true);
		//Assert.assertNotEquals(addedqty, sQty);
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest(groups={"init"})
  public void beforeTest() {
	  driver.get("https://demo.opencart.com");
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite(groups={"init"})
  @Parameters({"browser"})
   public void beforeSuite(String sBrowser) {
	  if(sBrowser.equalsIgnoreCase("chrome"))
			  {
		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
			  }
	  else if(sBrowser.equalsIgnoreCase("firefox"))
			  {
		  System.setProperty("webdriver.gecko.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
			  }
	  else if(sBrowser.equalsIgnoreCase("ie"))
			  {
		  System.setProperty("webdriver.ie.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
			  }
	  else
	  {
		  System.out.println("Sorry, not a valid browser:-"+sBrowser);
	  }
	  
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
