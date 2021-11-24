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
public class Ordersummarypage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement conformationpage;
	
	public Ordersummarypage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Orderconformationpage checkconformpage() throws Throwable {
		Action.click(getdriver(), conformationpage);
		return new Orderconformationpage();
	}

}
