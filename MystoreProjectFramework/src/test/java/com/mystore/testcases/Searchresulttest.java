/**
 * 
 */
package com.mystore.testcases;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Searchresultpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class Searchresulttest extends BaseClass {
	indexpage Index;
	Searchresultpage searchpage;
    
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
	public void validatesearchpage() throws Throwable {
		Index = new indexpage();
		searchpage=Index.validateSearchbox("t-shirt");
		boolean result=searchpage.isproductavalaible();
		Assert.assertTrue(result);
	}
}
