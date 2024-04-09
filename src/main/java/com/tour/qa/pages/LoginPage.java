package com.tour.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
		
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public AppListPage login1(String un, String pwd) throws InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
//		Thread.sleep(2000);
		

		return new AppListPage();
		
		
	}
}
