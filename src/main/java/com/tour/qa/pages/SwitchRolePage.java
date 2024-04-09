package com.tour.qa.pages;

import org.openqa.selenium.By;

import com.tour.qa.base.TestBase;

public class SwitchRolePage extends TestBase {
	
	public String ValidateSwitchRolePageTitle() 
	{
		
		return driver.getTitle();
	}
	
	public HomePage ClickOnSelectRoleBtn()
	{
		driver.findElement(By.xpath("//input[@id='changeUserRole']")).click();
		return new HomePage();
		
	}

}
