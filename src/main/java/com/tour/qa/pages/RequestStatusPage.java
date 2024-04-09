package com.tour.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.qa.base.TestBase;

public class RequestStatusPage extends TestBase
{
	
	@FindBy(xpath="//div[@id='reqStatusTable_filter']//input[@type='search']")
	WebElement searchap;
	
	public RequestStatusPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SearchReqId(String reqid)
	{
		searchap.sendKeys(reqid);
		int count=0;
		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='reqStatusTable']//td"));
		for(WebElement ele:alldata)
		{
			if(ele.getText().equals(reqid))
			{
				break;
			}
           count++;
		}
		alldata.get(count+6).click();
	}

}
