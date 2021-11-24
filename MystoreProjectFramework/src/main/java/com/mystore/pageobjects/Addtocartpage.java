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
public class Addtocartpage extends BaseClass {
	
	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(name = "Submit")
	WebElement addtocart;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement cartpagetitle;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement clickproceed;
	
	public Addtocartpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
    public void enterquantity(String quantity1) throws Throwable {
    	Action.type(quantity, quantity1);
    }
    
    public void selectsize(String size1) throws Throwable {
    	Action.selectByVisibleText(size1, size);
    }
    
    public void clickonaddtocart() throws Throwable {
    	Action.click(getdriver(), addtocart);
    }
    
    public boolean validateaddtocart() throws Throwable {
    	Action.fluentWait(getdriver(), cartpagetitle, 10);
    	return Action.isDisplayed(getdriver(), cartpagetitle);
    }
    
    public Orderpage clickoncheckout() throws Throwable {
    	Action.fluentWait(getdriver(), clickproceed, 10);
    	Action.JSClick(getdriver(), clickproceed);
    	
    	return new Orderpage();
    }
}
