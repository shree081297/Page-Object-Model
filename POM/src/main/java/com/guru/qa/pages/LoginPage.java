package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.testbase;

public class LoginPage extends testbase {
	
	@FindBy(xpath="//td//input[@type='text']")
	WebElement UserId;//userID
	
	@FindBy(css="[type='password']")
	WebElement password;//password
	
	@FindBy(css="[name='btnLogin']")
	WebElement Loginbtn;//login button
	
	@FindBy(css="h2.barone")
	WebElement logo;//logo
	
	public LoginPage() {
	PageFactory.initElements(driver, this);//By using pagefactory i was initlizing the elements by using my driver
	//in this class
	}
	public String validateLoginpageTitle() {//we are verifying the title
		return driver.getTitle();
	}
	public boolean validateLoginpageLogo() {//we are verifying the logo that present or not
		return logo.isDisplayed();
	}
	public HomePage loginTest(String ui, String pwd) throws Exception {
		Thread.sleep(4000);
		UserId.sendKeys(ui);
		password.sendKeys(pwd);
		Loginbtn.click();
		return new HomePage();
	}

}
