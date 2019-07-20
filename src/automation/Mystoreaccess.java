package automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mystoreaccess {
	
	
     static WebDriver driver;
     
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String newBrowser="";
		//String currentBrowser=driver.getWindowHandle();
		//Set<String>allBrowser=driver.getWindowHandles();
		String qtyCheck="3";
		String insertSize="M";
		//System.setProperty(“propertyName”, “value”)” 
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com");
		//driver.findElement(By.linkText("Women"));
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]")).click();
		////div[@id="center_column"]/ul/li/div/div/h5/a[@title="Faded Short Sleeve T-shirts"]
		//driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div/h5/a[@title='Faded Short Sleeve T-shirts']")).click();
	    //driver.findElement(By.xpath("//input[@id='quantity_wanted']")).click();
		String beforeSelected=driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']")).getText();
		System.out.println(beforeSelected);
		driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']")).click();
		driver.findElement(By.name("qty")).clear();
		driver.findElement(By.name("qty")).sendKeys("3");
		////div[@id="uniform-group_1"]
		//driver.findElement(By.xpath("//[@id='accordion']/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//div[@id='uniform-group_1']")).click();
		new Select(driver.findElement(By.name("group_1"))).selectByVisibleText("M");
		driver.findElement(By.xpath("//li/a[@name='Blue']")).click();
		driver.findElement(By.xpath("//div/p[@id='add_to_cart']")).click();
		//String Actualsel=driver.findElement(By.xpath("//div[1]/a[@title='Faded Short Sleeve T-shirts']")).getText();
//		for(String s:allBrowser)
//		   {
//			   if(!s.equals(currentBrowser))
//					   {
//				   
//				         newBrowser=s;
//				         break;
//					   }
//				   
//				   
//			   }
//		   
//		   driver.switchTo().window(newBrowser);
//		
			String Actualsel=driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/div[2]/span[@id='layer_cart_product_title']")).getText();
			String actualSize=driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText();
			String actualQty=driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
		if(beforeSelected.equalsIgnoreCase(Actualsel)) {
			System.out.println("Added product is matching" +Actualsel);
			}
		else {
			System.out.println("Added product is not matching, Expected : "+beforeSelected+" Actual : "+Actualsel);
		}
		if(actualQty.contains(qtyCheck))
		{
			System.out.println("Added Qty is matching");
		}
		else {
			System.out.println("Added Qty is not matching, Expected : "+qtyCheck+" Actual : "+actualQty);
		}
		if(insertSize.contains(actualSize))
		{
			System.out.println("Added Qty is matching");
		}
		else {
			System.out.println("Added Qty is not matching, Expected : "+insertSize+" Actual : "+actualSize);
		}
		
		
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		driver.close();
		
		

	}

}
