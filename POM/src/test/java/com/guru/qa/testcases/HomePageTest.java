package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.testbase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewCustomer;

public class HomePageTest extends testbase{
	HomePage homepage;//object for parent class
	 NewCustomer newCustomer;
	 LoginPage Loginpage;
	public HomePageTest(){
		super();//that is used for getting parent class object or constructor
	}
	@BeforeMethod
	public void setUp() throws Exception {
		init();
		 Loginpage=new LoginPage();
		homepage=Loginpage.loginTest(prop.getProperty("userid"),prop.getProperty("password"));
		  
	}
	@Test(priority=0)
	public void validateTitle() {
		String actualTitle=homepage.HomePageTitle();//by using object varable i was
										//calling the methods directly in this method
		Assert.assertEquals(actualTitle, "Guru99 Bank Manager HomePage");
	}
	@Test(priority=1)
	public void validateLogo() {
		Assert.assertTrue(homepage.validateHomepageLogo());
	}
	@Test(priority=2)
	public void navigateToNewCustomerPage() {
		newCustomer=homepage.ClickBtn();
	}
	@AfterMethod
	public void closeAll() {
		driver.quit();
	}

}
