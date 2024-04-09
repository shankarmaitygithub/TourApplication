package com.tour.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tour.qa.base.TestBase;

public class AppListPage extends TestBase{
	

	@FindBy(xpath="//a[text()='HRMS']")
	WebElement hrmslink;
	
	public AppListPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateAppListPageTitle() {
		return driver.getTitle();
	}
	
	public SwitchRolePage SelectApp() throws InterruptedException {
		
		hrmslink.click();
//		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.dismiss();
		Thread.sleep(1000);
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		String parentid= it.next();
//		System.out.println(parentid);
		String childid= it.next();
//		System.out.println(childid);
		driver.switchTo().window(childid);
		
		
		Thread.sleep(2000);
		
		
		return new SwitchRolePage();
	}
	

}
