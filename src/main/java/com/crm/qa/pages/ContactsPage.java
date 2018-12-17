package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseTest;


public class ContactsPage extends BaseTest {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
   // @FindBy(xpath="//a[text()='arjun lohit']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")

	@FindBy(id="first_name")
	WebElement fName;

	@FindBy(id="surname")
	WebElement lName;

	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(xpath="//input[@type='submit' and  @value='Save']")
	WebElement savebtn;
	
      public ContactsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifycontactslabel() {
		return contactslabel.isDisplayed();
	}
	
	
	public void selectcontactsbyname(String name) {
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	public void createNewContacts(String title,String fname,String lname, String comp) {
		
		Select sel=new Select(driver.findElement(By.name("title")));
				sel.selectByVisibleText(title);
				
				fName.sendKeys(fname);
				lName.sendKeys(lname);
				Company.sendKeys(comp);
				savebtn.click();
	
		
		
	}
	
}
