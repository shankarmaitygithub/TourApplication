package com.tour.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.SwitchRolePage;

public class SwitchRolePageTest extends TestBase {
	
	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	
	public SwitchRolePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		loginpage=new LoginPage();
		applistpage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		switchrolepage=applistpage.SelectApp();
		
	}
	
	@Test(priority=1)
	public void ValidateSwitchRolePageTitleTest()
	{
		String title=switchrolepage.ValidateSwitchRolePageTitle();
		Assert.assertEquals(title, "HRMS | Switch Role");
		
	}
	
	@Test(priority=2)
	public void ClickOnSwitchRoleBtnTest() throws InterruptedException 
	{
		
		homepage=switchrolepage.ClickOnSelectRoleBtn();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
