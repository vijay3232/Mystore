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
public class Shippingpage extends BaseClass {
	
	@FindBy(id = "cgv")
	WebElement checkboxclick;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	
	
	public Shippingpage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public void checkterms() throws Throwable {
		Action.click(getdriver(), checkboxclick);
	}
	
	public Paymentpage proceedtocheckoutbtn() throws Throwable {
		
		Action.click(getdriver(), proceedtocheckout);
		return new Paymentpage();
	}

}
