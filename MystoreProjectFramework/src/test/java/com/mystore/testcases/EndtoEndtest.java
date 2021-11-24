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
import com.mystore.pageobjects.Addresspage;
import com.mystore.pageobjects.Addtocartpage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.Orderconformationpage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.Ordersummarypage;
import com.mystore.pageobjects.Paymentpage;
import com.mystore.pageobjects.Searchresultpage;
import com.mystore.pageobjects.Shippingpage;
import com.mystore.pageobjects.indexpage;

/**
 * @author admin
 *
 */
public class EndtoEndtest extends BaseClass {
indexpage Index;
Searchresultpage searchpage;
Addtocartpage cartpage;
Orderpage orderpage;
Loginpage loginpage;
Addresspage addresspage;
Shippingpage shippingpage;
Paymentpage paymentpage;
Ordersummarypage ordersumpage;
Orderconformationpage conformtionpage;


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
		Index = new indexpage();
		searchpage = Index.validateSearchbox("t-shirt");
		cartpage= searchpage.clickonproduct();
		cartpage.enterquantity("2");
		cartpage.selectsize("M");
		cartpage.clickonaddtocart();
		orderpage = cartpage.clickoncheckout();
		loginpage = orderpage.clickproceedtocheckout();
		addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage=addresspage.clickproceedcheckout();
		shippingpage.checkterms();
		paymentpage=shippingpage.proceedtocheckoutbtn();
		ordersumpage=paymentpage.clickbankwire();
		conformtionpage=ordersumpage.checkconformpage();
		String actualmessage=conformtionpage.checkconformationmsg();
		String expectedmessage="Your order on My Store is complete.";
		Assert.assertEquals(actualmessage, expectedmessage);
	}
}
