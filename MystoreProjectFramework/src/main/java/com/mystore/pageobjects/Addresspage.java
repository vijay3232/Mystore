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
public class Addresspage extends BaseClass {
	

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public Addresspage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public Shippingpage clickproceedcheckout() throws Throwable {
		Action.click(getdriver(), proceedtocheckout);
		return new Shippingpage();
	}
	

}
