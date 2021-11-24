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
import com.mystore.pageobjects.Accountcreationpage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class Accountcreationtest extends BaseClass {
	indexpage Indexpage;
	Loginpage loginpage;
	Accountcreationpage accountcreation;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		launchapp(browser);
	}
	
	@AfterMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getdriver().quit();
	}
     
	@Test(groups = "Sanity")
	public void validateaccountcreationpage() throws Throwable {
		Indexpage = new indexpage();
		loginpage=Indexpage.clickonsignin();
		accountcreation=loginpage.Createnewaccount("abfhjuhj@gmail.com");
		boolean result = accountcreation.newaccountcreate();
		Assert.assertTrue(result);
	}
	
}
