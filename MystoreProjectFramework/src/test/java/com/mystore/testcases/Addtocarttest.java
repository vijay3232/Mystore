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
import com.mystore.pageobjects.Addtocartpage;
import com.mystore.pageobjects.Searchresultpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class Addtocarttest extends BaseClass {
	indexpage index;
	Searchresultpage searchpage;
	Addtocartpage addtocart;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		launchapp(browser);
	}
	
	@AfterMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getdriver().quit();
	}
	
	
	@Test(groups = {"Regression" , "Sanity"})
	public void validateaddtocarttest() throws Throwable {
		index = new indexpage();
		searchpage=index.validateSearchbox("t-shirt");
		addtocart=searchpage.clickonproduct();
		addtocart.enterquantity("3");
		addtocart.selectsize("M");
		addtocart.clickonaddtocart();
		boolean result=addtocart.validateaddtocart();
		Assert.assertTrue(result);
	}
}
