/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author admin
 *
 */
public class Paymentpage extends BaseClass {
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement paybankbywire;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement paybycheck;
	
	public Paymentpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Ordersummarypage clickbankwire() throws Throwable {
		Action.click(getdriver(), paybankbywire);
		return new Ordersummarypage();
	}
	

}
