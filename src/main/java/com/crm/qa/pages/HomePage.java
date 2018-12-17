package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;


public class HomePage extends BaseTest{
	
	
	@FindBy(xpath="//td[contains(text(),'User: Arjun M S')]")
	WebElement usernamelbl;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontacts;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	

	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newdeals;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
          
	
	    public HomePage() {
		
		PageFactory.initElements(driver, this);
	
	    }
	
	    public String verifyhomepagetitle() {
	    	return driver.getTitle();
	    }
	    
	    public boolean verifyusername() {
	    	return usernamelbl.isDisplayed();
	    }
	
	    public ContactsPage clickoncontactslink() {
	    	contactslink.click();
	    	return new ContactsPage();	
	    }
	
	    public DealsPage clickondealslink() {
	    	dealslink.click();
	    	return new DealsPage();
	
	    }
	    public TasksPage clickontaskslink() {
	    	taskslink.click();
	    	return new TasksPage();
	
	    }
	
	    public void clickoncontacts() {
	    	Actions act=new Actions(driver);
	    	act.moveToElement(contactslink).build().perform();
	    	newcontacts.click();
	    }
	    
	    public void clickonnewdealslink() {
	    	Actions act=new Actions(driver);
			act.moveToElement(dealslink).build().perform();
			newdeals.click();
			
	    	
	    }
	

}
