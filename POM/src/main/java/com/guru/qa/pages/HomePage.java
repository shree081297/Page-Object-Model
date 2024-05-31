package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.testbase;

public class HomePage extends testbase{
	
	@FindBy(css="h2.barone")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustomer;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle() {
		return driver.getTitle();//getting the title
	}
	
	public boolean validateHomepageLogo() {
		return logo.isDisplayed();//getting logo
		
	}
	
	public NewCustomer ClickBtn() {
		NewCustomer.click();//performing click action
		return new NewCustomer();
	}
	
	

}
