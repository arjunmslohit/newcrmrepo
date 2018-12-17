package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;


public class DealsPage extends BaseTest {
	
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement Dealslabel;
	
	@FindBy(id="title")
	WebElement Title;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(name="contact_lookup")
	WebElement pcontact;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDealsLabel() {
		
		return Dealslabel.isDisplayed();
		
	}
	
	public void CreatenewDeal(String titl, String comp,String cont ) {
	
	Title.sendKeys(titl);
	Company.sendKeys(comp);
	pcontact.sendKeys(cont);
	savebtn.click();

}
}
