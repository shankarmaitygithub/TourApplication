package com.tour.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.RequestStatusPage;
import com.tour.qa.pages.SwitchRolePage;
import com.tour.qa.pages.TourApplicationPage;
import com.tour.qa.pages.TourApplictionReqestPage;

public class RequestStatusPageTest extends TestBase {
	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	RequestStatusPage reqstatuspage;
	TourApplictionReqestPage tourappreqpage;
	TourApplicationPage tourapppage;
	
	
	public RequestStatusPageTest() {
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
		reqstatuspage=homepage.ClickonTadaAndInbox();
		
//		Thread.sleep(3000);	
	}
	@Test
	public void InitaiteTourApplication() throws InterruptedException
	{
		tourappreqpage=homepage.ClickOnTaDaLink();
		tourapppage=tourappreqpage.ClickOnEmpSearcLov(prop.getProperty("EmployeeId"));
	}
}
