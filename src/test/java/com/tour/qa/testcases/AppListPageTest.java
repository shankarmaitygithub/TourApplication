package com.tour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.SwitchRolePage;

public class AppListPageTest extends TestBase{
	
	public LoginPage login;
	public AppListPage applistpage;
	public SwitchRolePage switchrolepage;
	
	public AppListPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		applistpage=login.login1(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
//	@Test
//	public void AppListPageTitleTest() {	
//	String title=applistpage.validateAppListPageTitle();
//	Assert.assertEquals(title, "Application List");
//	}
	
	@Test
	public void SelectAppTest() throws Exception {
		switchrolepage=applistpage.SelectApp();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}


}
