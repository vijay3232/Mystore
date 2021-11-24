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
public class Accountcreationpage extends BaseClass {
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement fromtitle;
	
	public Accountcreationpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean newaccountcreate() throws Throwable
	{
		return Action.isDisplayed(getdriver(), fromtitle);
	}
	

}
