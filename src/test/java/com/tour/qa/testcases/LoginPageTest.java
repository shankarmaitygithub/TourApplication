package com.tour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	public LoginPage login;
	public AppListPage applistpage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login= new LoginPage();
	}
	
//	@Test
//	public void loginPageTitleTest() {
//	String title = login.validateLoginPageTitle();
//	Assert.assertEquals(title, "iFMS Login");
		
//	}
	
	@Test
	public void loginTest() throws InterruptedException {
		applistpage = login.login1(prop.getProperty("username"), prop.getProperty("password"));
//	    Thread.sleep(3000);
		
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
