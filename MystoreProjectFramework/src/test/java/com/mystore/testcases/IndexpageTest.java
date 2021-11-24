/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class IndexpageTest extends BaseClass {
	indexpage Indexpage;
	
	
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
	public void verifylogo() throws Throwable {
		Indexpage = new indexpage();
		boolean result = Indexpage.validatelogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifytitle() {
		String actualtitle=Indexpage.getMystoretitle();
		Assert.assertEquals(actualtitle, "My Store");
	}

}
