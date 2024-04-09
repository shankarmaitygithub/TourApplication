package com.tour.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.EmpSelectPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.SwitchRolePage;
import com.tour.qa.pages.TourApplictionReqestPage;

public class EmpSelectPageTest extends TestBase{
	
	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	TourApplictionReqestPage tourappreqpage;
	EmpSelectPage empselectpage;
	

	public EmpSelectPageTest() {
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
		tourappreqpage=homepage.ClickOnTaDaLink();
//		empselectpage=tourappreqpage.ClickOnEmpSearcLov();
		
	}
	
//	@Test(priority=1)
//	public void ValidateEmpSelectPageTitleTest()
//	{
//		Assert.assertEquals(empselectpage.ValidateEmpSelectPageTitle(), "LOV");
//	}
	
	
	@Test(priority=2)
	public void EmployeeSearchTest() throws InterruptedException 
	{
		empselectpage.EmployeeSearch();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
		
		
		
		
		
		
		
		
		
		
		

}
