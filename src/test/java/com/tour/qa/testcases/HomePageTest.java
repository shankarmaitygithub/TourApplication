package com.tour.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.RequestStatusPage;
import com.tour.qa.pages.SwitchRolePage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	RequestStatusPage reqstatuspage;
	
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		loginpage= new LoginPage();
		applistpage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		switchrolepage=applistpage.SelectApp();
		homepage=switchrolepage.ClickOnSelectRoleBtn();
		
//		Thread.sleep(3000);	
	}
	
	
//	@Test(priority=1)
//	public void HomePageTitleTest() 
//	{
//	String title1 =	homepage.validateHomePageTitle();
//	Assert.assertEquals(title1, "HRMS");
//	}	
//	
//	
//	@Test(priority=2)
//	public void IFMSLOGOTest() throws InterruptedException
//		{
//		boolean logo = homepage.IFMSLOGO();
//		Assert.assertTrue(logo, "Mishmatch");
//	}
	
//	@Test(priority=3)
//	public void ClickOnTADALinkTest() throws InterruptedException
//	{
//		homepage.ClickOnTaDaLink();
//		Thread.sleep(10000);
//	}
	
	
	@Test
	public void ClickonTadaAndInboxTest() throws InterruptedException
	{
		
		reqstatuspage=homepage.ClickonTadaAndInbox();
		Thread.sleep(10000);
		
	}
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	

}
