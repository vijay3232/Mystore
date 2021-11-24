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
import com.mystore.dataprovider.Dataproviders;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.indexpage;
import com.mystore.utility.Log;



/**
 * @author admin
 *
 */
public class Loginpagetest extends BaseClass{
	
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
	
	@Test(dataProvider = "credentials" , dataProviderClass = Dataproviders.class , groups={"Sanity" , "Smoke"})
	public void Logintest(String uname , String pass) throws Throwable {
		Log.startTestCase("Logintest");
		Indexpage = new indexpage();
		Log.info("user going to click on signin button");
		loginpage=Indexpage.clickonsignin();
		Log.info("Enter username and Password");
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(uname, pass);
		String actualurl=homepage.getCurrenturl();
		String expectedurl="http://automationpractice.com/index.php?controller=my-account";
	   Assert.assertEquals(actualurl, expectedurl);
	   Log.info("Login is successfully Done");
	   Log.endTestCase("Logintest");
	}

}
