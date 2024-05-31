package com.guru.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testbase {
	public static Properties prop;
	public static  WebDriver driver;
	public testbase() {//constructor
		try {
		 prop=new Properties();

			FileInputStream ip=new FileInputStream("C:\\Users\\srika\\git\\Page-Object-Model\\POM\\src\\main\\java\\com\\guru\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();

		}

	}
	public void init() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
System.setProperty("webdriver.chrome.driver","C:\\Users\\srika\\OneDrive\\Desktop\\Git_Assesment\\chromedriver-win64\\chromedriver.exe");
			 driver=new ChromeDriver();//for opening a browser
		}else if(browserName.equals("edge")) {
			 driver=new EdgeDriver();//for opening a browser
		}else if(browserName.equals("firefox")) {
			 driver=new FirefoxDriver();//for opening a browser

		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
}
