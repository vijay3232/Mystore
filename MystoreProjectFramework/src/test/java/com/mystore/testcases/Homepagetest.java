/**
 * 
 */
package com.mystore.testcases;



import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class Homepagetest extends BaseClass {
	indexpage Indexpage;
	Loginpage loginpage;
	Homepage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		launchapp(browser);
	}
	
	@AfterMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getdriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void validatemywishlist() throws Throwable {
		Indexpage = new indexpage();
		loginpage=Indexpage.clickonsignin();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homepage.validatemywishlist();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void orderofmywishlist() throws Throwable {
		Indexpage = new indexpage();
		loginpage=Indexpage.clickonsignin();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homepage.validatemyorderhistory();
		Assert.assertTrue(result);
	}

}
