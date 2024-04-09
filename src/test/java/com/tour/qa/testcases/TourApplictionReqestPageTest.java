package com.tour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.EmpSelectPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.SwitchRolePage;
import com.tour.qa.pages.TourApplicationPage;
import com.tour.qa.pages.TourApplictionReqestPage;

public class TourApplictionReqestPageTest extends TestBase
{

	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	TourApplictionReqestPage tourappreqpage;
	TourApplicationPage tourapppage;
//	EmpSelectPage empselectpage;
	
	public TourApplictionReqestPageTest ()
	{
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
		
	
	}
	
	@Test
	public void ClickOnEmpSearcLovTest() throws InterruptedException
	{
		tourapppage=tourappreqpage.ClickOnEmpSearcLov(prop.getProperty("EmployeeId"));
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
