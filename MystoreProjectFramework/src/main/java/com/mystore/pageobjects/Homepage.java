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
public class Homepage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement checkmywishlist;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderhistory;
	
	public Homepage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public boolean validatemywishlist() throws Throwable {
		return  Action.isDisplayed(getdriver(), checkmywishlist);
	}
	
	public boolean validatemyorderhistory() throws Throwable {
		return Action.isDisplayed(getdriver(), orderhistory);
	}
	
	public String getCurrenturl() {
		String homepageurl=getdriver().getCurrentUrl();
		return homepageurl;
	}

}
