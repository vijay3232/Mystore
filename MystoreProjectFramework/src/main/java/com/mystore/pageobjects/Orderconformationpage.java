/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author admin
 *
 */
public class Orderconformationpage extends BaseClass {
	
	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmationpage;
	
   public Orderconformationpage() {
	   PageFactory.initElements(getdriver(), this);
   }
   
   public String checkconformationmsg() {
	   String conformmsg=confirmationpage.getText();
	   return conformmsg;
   }
}
