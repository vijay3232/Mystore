package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class indexpage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signinbtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement mystorelogo;
	
	@FindBy(id="search_query_top")
	WebElement searchbox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchbtn;
	
	public indexpage() {
		PageFactory.initElements(getdriver(), this);
	}

	public Loginpage clickonsignin() throws Throwable {
		Action.click(getdriver(), signinbtn);
		return new Loginpage();
	}
		public boolean validatelogo() throws Throwable {
			return Action.isDisplayed(getdriver(), mystorelogo);
		}
		
		public String getMystoretitle() {
			String titlepage=getdriver().getTitle();
			return titlepage;
		}
		
		public Searchresultpage validateSearchbox(String productname) throws Throwable {
			Action.type(searchbox,productname);
			Action.click(getdriver(), searchbtn);
			return new Searchresultpage();
		}
	}

