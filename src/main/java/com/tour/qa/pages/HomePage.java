package com.tour.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//img[@src='/wbifms-menu/images/logo.png']")
	WebElement ifmslogo;
	
	@FindBy(xpath="//a[@title=' TA/TC/HTC/LTC']")
	WebElement TA_TC_HTC_LTClink;
	
//	@FindBy(xpath="//a[@title='Apply for Official Tour']")
//	WebElement tourapplink;
	
	
	
	
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean IFMSLOGO() throws InterruptedException 
	{
		Thread.sleep(1000);
		driver.switchTo().frame("topFrame");
		return ifmslogo.isDisplayed();
	}
	
	public TourApplictionReqestPage ClickOnTaDaLink() throws InterruptedException
	{
		driver.switchTo().frame("leftFrame");
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",tadalink);
		js.executeScript("window.scrollBy(0,1500)");
		TA_TC_HTC_LTClink.click();
		
//Click On Tour Link----->		
		List<WebElement> list =driver.findElements(By.xpath("//ul[@class='jstree-children']//li//a"));
		for(WebElement ele : list)
		{
			String menu= ele.getText();
			if(menu.equals("Tour"))
			{
				ele.click();
				break;
			}
		}
		Thread.sleep(1000);
		
//Click On Apply for Official tour Link		
//Method 1	
		List<WebElement> list1 =driver.findElements(By.xpath("//li[contains(@id,'153')]//a"));
		for(WebElement ele : list1)
		{
			String menu= ele.getText();
			if(menu.equals("Apply for Official Tour"))
			{
				ele.click();
				break;
			}
		}
		
//Method 2		
//		tourapplink.click();
		
		return new TourApplictionReqestPage();
			
	}
	
	public RequestStatusPage ClickonTadaAndInbox() throws InterruptedException
	{
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.switchTo().frame("leftFrame");
		js.executeScript("arguments[0].scrollIntoView();",TA_TC_HTC_LTClink);
//		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("leftFrame");
		TA_TC_HTC_LTClink.click();
		
//Click On Inbox Link----->		
		List<WebElement> list =driver.findElements(By.xpath("//ul[@class='jstree-children']//li//a"));
		for(WebElement ele : list)
		{
			String menu= ele.getText();
			if(menu.equals("Inbox for TA/TC/HTC/LTC"))
			{
				ele.click();
				break;
			}
		}
		
		return new RequestStatusPage();
	}
	

}
