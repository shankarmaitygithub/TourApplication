package com.tour.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.qa.base.TestBase;

public class TourApplictionReqestPage extends TestBase
{

	@FindBy(xpath="//img[@id='empIdlov']")
	WebElement empsearchlov;
	
	@FindBy(xpath="//input[@id='searchEmpDtls']")
	WebElement searchbtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement empsearch;

	public TourApplictionReqestPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public TourApplicationPage ClickOnEmpSearcLov(String EmpId) throws InterruptedException 
	{
	driver.switchTo().defaultContent();
	driver.switchTo().frame("mainFrame");
	Thread.sleep(1000);
	empsearchlov.click();
	
	Thread.sleep(1000);
	Set<String> handler = driver.getWindowHandles();
	Iterator<String> it= handler.iterator();
	String parentid1= it.next();
	String childid1= it.next();
	String childid2= it.next();
//	System.out.println(childid2);
	driver.switchTo().window(childid2);
//	System.out.println(driver.getTitle());
	
	empsearch.sendKeys(EmpId);
	
	List<WebElement> allemplist=driver.findElements(By.xpath("//table[@id='multiLovTable']//td"));
	for(WebElement ele:allemplist)
	{
		if(ele.getText().equals(EmpId))
		{
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			break;
		}
	}
	driver.switchTo().window(childid1);
//	System.out.println(driver.getTitle());
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("mainFrame");
	searchbtn.click();

	return new TourApplicationPage();
//	return new EmpSelectPage();
	}
	
	
}
