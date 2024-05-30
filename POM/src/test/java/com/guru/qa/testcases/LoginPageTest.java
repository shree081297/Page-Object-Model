package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.testbase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;


public class LoginPageTest extends testbase{
	LoginPage Loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		init();
		Loginpage=new LoginPage();
}
	@Test(priority=0)
	public void validateTitle() {
		String actualTitle=Loginpage.validateLoginpageTitle();
		Assert.assertEquals(actualTitle, "Guru99 Bank Home Page");
	}
	@Test(priority=1)
	public void validateLogo() {
		Assert.assertTrue(Loginpage.validateLoginpageLogo());
	}
	@Test(priority=2)
	public void loginToApp() throws Exception {
		homepage=Loginpage.loginTest(prop.getProperty("userid"),prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}