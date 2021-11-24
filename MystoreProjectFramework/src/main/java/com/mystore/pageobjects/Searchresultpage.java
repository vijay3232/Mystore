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
public class Searchresultpage extends BaseClass {
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productresult;
	
	
	public Searchresultpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean isproductavalaible () throws Throwable {
		return Action.isDisplayed(getdriver(), productresult);
	}
	
	public Addtocartpage clickonproduct() throws Throwable {
		Action.click(getdriver(), productresult);
		return new Addtocartpage();
	}

}
