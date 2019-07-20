package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
   driver=new ChromeDriver();
   driver.get("https://jqueryui.com/droppable/");
  
   driver.manage().window().maximize();
   Actions actions=new Actions(driver);
   WebElement resizable=driver.findElement(By.linkText("Resizable"));
   actions.moveToElement(resizable).build().perform();
   Thread.sleep(5000);
   driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
    WebElement draggable=driver.findElement(By.cssSelector("#draggable"));
   WebElement droppable=driver.findElement(By.cssSelector("#droppable"));
   actions.dragAndDrop(draggable, droppable).build().perform();
   driver.quit();
   
   
	}

}
