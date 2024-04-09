package com.tour.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tour.qa.base.TestBase;

public class TourApplicationPage extends TestBase {
//	
	@FindBy(xpath="//input[@id='modeOfTravel_0']")
	WebElement TravelMode;
	
	@FindBy(xpath="//input[@id='farePaid_0']")
	WebElement TravelFare;
	
	@FindBy(xpath="//input[@id='headquarter_']")
	WebElement Headquater;
	
	@FindBy(xpath="//input[@id='residentialAddress_']")
	WebElement ResAddress;
	
	@FindBy(xpath="//textarea[@id='stayPurpose_']")
	WebElement Perpose;
	
	@FindBy(xpath="//input[@id='stayDuration_']")
	WebElement Duration;
	
	@FindBy(xpath="//input[@id='advanceReqN']")
	WebElement AdvanceFlag;
	
	
	public TourApplicationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Method no 1------------------
	
	public void ClickOnDepartureCalender(String source, String calmonth, String calyr, String jnsrtdate) throws InterruptedException 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='journeySource_0']")).sendKeys(source);
		
		driver.findElement(By.xpath("//input[@id='journeySourceDate_0']")).click();
		Select month_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drop.selectByVisibleText(calmonth);
		
		Select year_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drop.selectByVisibleText(calyr);
		

		List<WebElement> allDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele : allDate)
		{
			String dt=ele.getText();
			if(dt.equals(jnsrtdate))
			{
				ele.click();
				break;
			}		
		}
			
	}
	
//Method no 2---------------------	
	
	public void ClickOnArrivalCalender(String dest, String calmonth, String calyr, String jnsrtdate) throws InterruptedException 
	{
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='journeyDestination_0']")).sendKeys(dest);
		
		driver.findElement(By.xpath("//input[@id='journeyDestDate_0']")).click();
		Select month_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drop.selectByVisibleText(calmonth);
		
		Select year_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drop.selectByVisibleText(calyr);
		

		List<WebElement> allDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele : allDate)
		{
			String dt=ele.getText();
			if(dt.equals(jnsrtdate))
			{
				ele.click();
				break;
			}		
		}
			
	}
	
//Method no 3-------------------------	
	
	public void FillAppDetails(String TravMode, String TravFare, String Headqua, String Resadd, String Purps, String Deu) 
	{
		TravelMode.sendKeys(TravMode);
		TravelFare.sendKeys(TravFare);
		Headquater.sendKeys(Headqua);
		ResAddress.sendKeys(Resadd);
		Perpose.sendKeys(Purps);
		Duration.sendKeys(Deu);
		AdvanceFlag.click();
	}
	
// Combine all 3 methods-------------
	
	public String FillAllTourAppDetAndSave(String source, String calmonth, String calyr, String jnsrtdate, String dest,
			String calmonth1, String calyr1, String jnenddate,String TravMode, String TravFare, String Headqua, String Resadd,
			String Purps, String Deu) throws InterruptedException
	{
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='journeySource_0']")).sendKeys(source);
		
		driver.findElement(By.xpath("//input[@id='journeySourceDate_0']")).click();
		Select month_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drop.selectByVisibleText(calmonth);
		
		Select year_drop= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drop.selectByVisibleText(calyr);
		

		List<WebElement> allDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele : allDate)
		{
			String dt=ele.getText();
			if(dt.equals(jnsrtdate))
			{
				ele.click();
				break;
			}		
		}
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='journeyDestination_0']")).sendKeys(dest);
		
		driver.findElement(By.xpath("//input[@id='journeyDestDate_0']")).click();
		Select month_drop1= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drop1.selectByVisibleText(calmonth1);
		
		Select year_drop1= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drop1.selectByVisibleText(calyr1);
		

		List<WebElement> allDate1=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele : allDate1)
		{
			String dt=ele.getText();
			if(dt.equals(jnenddate))
			{
				ele.click();
				break;
			}		
		}
		
		TravelMode.sendKeys(TravMode);
		TravelFare.sendKeys(TravFare);
		Headquater.sendKeys(Headqua);
		ResAddress.sendKeys(Resadd);
		Perpose.sendKeys(Purps);
		Duration.sendKeys(Deu);
		AdvanceFlag.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='save']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		String Message=driver.findElement(By.xpath("//td[@style='padding: 5px 0px 5px 0px']")).getText();
		System.out.println(Message);
		String s=Message.replaceAll("[^0-9]","");
//		System.out.println("Ref No Is : "+s);
		return s;
	}
	

}
