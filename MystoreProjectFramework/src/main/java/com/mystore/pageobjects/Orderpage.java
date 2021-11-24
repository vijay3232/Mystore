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
public class Orderpage extends BaseClass{
	
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitprice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public Orderpage() {
		PageFactory.initElements(getdriver(),this);
	}
	
	public double getunitprice() {
		String unitprice1=unitprice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
	public double gettotalprice() {
		String totalprice1=totalprice.getText();
		String total=totalprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice=Double.parseDouble(total);
		return finalunitprice/100;
	}
	
	public Loginpage clickproceedtocheckout() throws Throwable {
		Action.click(getdriver(), proceedtocheckout);
		return new Loginpage();
	}

}
