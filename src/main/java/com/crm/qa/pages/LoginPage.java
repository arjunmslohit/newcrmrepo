package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	
	
	//page factory or Object repository
	
	//@findby
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logotst;
	
	
	//Initializing the page objects:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	
	public String ValidateTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCrmImage() {
		 return logotst.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
		
		
	}

}