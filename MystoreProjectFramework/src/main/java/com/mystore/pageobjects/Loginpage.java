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
public class Loginpage extends BaseClass {
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement loginbtn;
	
	@FindBy(id = "email_create")
	WebElement createnewemail;
	
	@FindBy(id = "SubmitCreate")
	WebElement clicksubmit;
	
	
	public Loginpage () {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Homepage login(String uname , String pass) throws Throwable {
		Action.type(username, uname);
		Action.type(password, pass);
		Action.click(getdriver(), loginbtn);
		return new Homepage();
	}
	
	public Addresspage login1(String uname , String pass) throws Throwable {
		Action.type(username, uname);
		Action.type(password, pass);
		Action.click(getdriver(), loginbtn);
		return new Addresspage();
	}
	
	public Accountcreationpage Createnewaccount(String newemail) throws Throwable {
		Action.type(createnewemail, newemail);
		Action.click(getdriver(), clicksubmit);
		return new Accountcreationpage();
		
	}
	
	
	
}
