package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Loginconfig;

public class AdminPage extends Loginconfig{
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="searchSystemUser_userName")
	WebElement searchUsernameAdminpage;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement searchUserroleAdminpage;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement searchEmployenameAdminpage;
	
	@FindBy(id="searchSystemUser_status")
	WebElement searchStatusAdminpage;
	
	@FindBy(id="searchBtn")
	WebElement searchButAdminpage;
	
	@FindBy(id="resetBtn")
	WebElement resetbutAdminpage;
	
	@FindBy(linkText="No Records Found")
	WebElement Nrecordsfound;
	
	@FindBy(xpath="//table/tbody/tr/td/a")
	WebElement srchlist;
	
	
	public void dropDownUserRole()
	{
		Select userRoleDD=new Select(searchUserroleAdminpage);
		userRoleDD.selectByVisibleText("Admin");
		
	}
	
	public void dropDownSearchStatus()
	{
		Select selectSearchStatus=new Select(searchStatusAdminpage);
		selectSearchStatus.selectByVisibleText("All");
	}
	
	public void searchResultSearchbut()
	{
		searchButAdminpage.click();
		
	}
	public void resetbtn()
	{
		resetbutAdminpage.click();
	}
	
	public void userNameSearch(String empNa)
	{
		searchUsernameAdminpage.sendKeys(empNa);
		searchButAdminpage.click();
	
		if(srchlist.getText().equalsIgnoreCase((empNa)))
		{
			System.out.println(" we have results shown");
			
		}
		
			else
		{
			if(Nrecordsfound.isDisplayed()){
				System.out.println("no records found");
			}
		}
		//return new AdminPage();
		
	}
	
	public HomePage navigateBack()
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php");
		return new HomePage();
	}
	
	
	
	

}
