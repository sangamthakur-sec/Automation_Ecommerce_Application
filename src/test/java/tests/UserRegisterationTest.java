package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration("automation","user","automationuserregistration@gmail.com","123456automation");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("automationuserregistration@gmail.com", "123456automation");
		
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
