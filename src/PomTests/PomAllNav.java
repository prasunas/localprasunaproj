package PomTests;

import java.util.Scanner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Loginconfig;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;


public class PomAllNav extends Loginconfig{
	
	LoginPage objLogin;
	HomePage objHome;
	AdminPage objAdmin;
	
	@BeforeTest
	public void login()
	
	{
		 objLogin=new LoginPage();
		 
		 
		  /*this is when login page is success will create teh home page now with the code written in class loginpage 32 to 37 lines
		   * instead of  objHome=new HomePage(); so commented below line 30*/
		  objHome=objLogin.login("admin", "admin123");
		 //objHome=new HomePage();
	}
	
	
  /*@Test
  public void VerifyLogin() {
	  
	 
	  objHome.verifyHomePage();
	  
	  
  }*/
	
  
  @Test
  
  public void verifyAdminFunctionality()
  {
	  objHome.verifyHomePage();
	  objAdmin=objHome.navigateToAdminPage();
	  objAdmin=new AdminPage();
	  objAdmin.userNameSearch("admin");
	// objAdmin.userNameSearch();
	  objHome=objAdmin.navigateBack();
  }
  
  @Test
  public void VerifyPIMFunctionality()
  {
	  objHome.navigateToPIMPage();
  }
 
}
