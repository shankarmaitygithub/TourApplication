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

public class EmpSelectPage extends TestBase{
	
	@FindBy(xpath="//input[@type='search']")
	WebElement empsearch;
	
	public EmpSelectPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateEmpSelectPageTitle()
	{
		return driver.getTitle();
	}
	
	public void EmployeeSearch() throws InterruptedException
	{
		empsearch.sendKeys("2011007250");
		Thread.sleep(2000);
		List<WebElement> allemplist=driver.findElements(By.xpath("//table[@id='multiLovTable']//td"));
		for(WebElement ele:allemplist)
		{
			if(ele.getText().equals("2011007250"))
			{
				Actions act = new Actions(driver);
				act.doubleClick(ele).perform();
				break;
			}
		}
		
		
	}


}
