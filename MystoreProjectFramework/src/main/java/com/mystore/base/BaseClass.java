package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.dockerjava.api.model.Driver;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	//Declare thrwadlocal driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke" , "Sanity" , "Regression"})
	public void loadconfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("Log4j.xml");
		
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(fis);
			System.out.println("driver:" + driver);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getdriver() {
		return driver.get();
	}
	
	
	public static void launchapp(String browsername) {
		WebDriverManager.chromedriver().setup();
		//String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("Chrome")) {
			//driver = new ChromeDriver();
			//Set browser threadlocal
			driver.set(new ChromeDriver());
		} 
		else if(browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browsername.equalsIgnoreCase("Edge")) {
			//WebDriverManager.iedriver().setup();
			WebDriverManager.edgedriver().setup();
			//driver = new InternetExplorerDriver();
			//driver.set(new InternetExplorerDriver());
			driver.set(new EdgeDriver());
		}
		
		getdriver().manage().window().maximize();
		Action.implicitWait(getdriver(), 10);
		Action.pageLoadTimeOut(getdriver(), 30);
		getdriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
