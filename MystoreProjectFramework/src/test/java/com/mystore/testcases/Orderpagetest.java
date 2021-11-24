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
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.Searchresultpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class Orderpagetest extends BaseClass {
	indexpage index;
	Searchresultpage searchpage;
	Addtocartpage cartpage;
	Orderpage order;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
		launchapp(browser);
	}
	
	@AfterMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void teardown() {
		getdriver().quit();
	}
	
	@Test(groups = "Regression")
	public void validateorderpagetest() throws Throwable {
		index = new indexpage();
		searchpage = index.validateSearchbox("t-shirt");
		cartpage= searchpage.clickonproduct();
		cartpage.enterquantity("2");
		cartpage.selectsize("M");
		cartpage.clickonaddtocart();
		order = cartpage.clickoncheckout();
		Double unitprice = order.getunitprice();
		Double totalprice = order.gettotalprice();
		Double totalexpectedprice = (unitprice*2)+2;
		Assert.assertEquals(totalprice, totalexpectedprice);
	}

}
