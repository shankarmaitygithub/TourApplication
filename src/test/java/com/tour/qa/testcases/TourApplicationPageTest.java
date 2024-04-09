package com.tour.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tour.qa.base.TestBase;
import com.tour.qa.pages.AppListPage;
import com.tour.qa.pages.HomePage;
import com.tour.qa.pages.LoginPage;
import com.tour.qa.pages.SwitchRolePage;
import com.tour.qa.pages.TourApplicationPage;
import com.tour.qa.pages.TourApplictionReqestPage;

public class TourApplicationPageTest extends TestBase{
	
	public String Id;
	LoginPage loginpage;
	AppListPage applistpage;
	SwitchRolePage switchrolepage;
	HomePage homepage;
	TourApplictionReqestPage tourappreqpage;
	TourApplicationPage tourapppage;
//	EmpSelectPage empselectpage;
	
	public TourApplicationPageTest ()
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
		tourapppage=tourappreqpage.ClickOnEmpSearcLov(prop.getProperty("EmployeeId"));
		
	
	}
	
//	@Test
//	public void ClickOnEmpSearcLovTest() throws InterruptedException
//	{
//		tourapppage.ClickOnDepartureCalender(prop.getProperty("Source"),prop.getProperty("JourneyToMonth"),prop.getProperty("JourneyToYear"),prop.getProperty("JourneyToDate"));
//		tourapppage.ClickOnArrivalCalender(prop.getProperty("Destination"),prop.getProperty("ArrivalMonth"),prop.getProperty("ArrivalYear"),prop.getProperty("ArrivalDate"));
//		tourapppage.FillAppDetails(prop.getProperty("TravelMode"), prop.getProperty("TravelFare"),prop.getProperty("Headquater"), prop.getProperty("ResAddress"),prop.getProperty("Purpose"), prop.getProperty("Duration"));
//		Thread.sleep(10000);
//	}
	
	
	@Test
	public void FillAllTourAppDetailsAndSaveTest() throws InterruptedException
	{
		Id=tourapppage.FillAllTourAppDetAndSave(prop.getProperty("Source"),prop.getProperty("JourneyToMonth"),prop.getProperty("JourneyToYear"),prop.getProperty("JourneyToDate"),
				prop.getProperty("Destination"),prop.getProperty("ArrivalMonth"),prop.getProperty("ArrivalYear"),prop.getProperty("ArrivalDate"),
				prop.getProperty("TravelMode"), prop.getProperty("TravelFare"),prop.getProperty("Headquater"), prop.getProperty("ResAddress"),prop.getProperty("Purpose"), prop.getProperty("Duration"));
		        System.out.println("Ref No Is : "+Id);
		        Thread.sleep(5000);
	}
	
	@Test
	public void aa()
	{
		System.out.println(Id);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
