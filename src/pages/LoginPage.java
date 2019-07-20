package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Loginconfig;

public class LoginPage extends Loginconfig {
	
	
	/*.....constructor......*/
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
		//pageFactory.initElements will intialise the locators or what ever we mentioned in below like username,pwd
	}
	
	//Webelement in login page
	
	@FindBy(id="txtUsername")
	WebElement userNameField;
	
	@FindBy(id="txtPassword")
	WebElement passWordField;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	public HomePage login(String uname, String pwd)
	{
		userNameField.sendKeys(uname);
		passWordField.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	

}
