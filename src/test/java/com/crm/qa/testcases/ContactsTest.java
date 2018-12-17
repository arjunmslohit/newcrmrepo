package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.UtilTest;


public class ContactsTest extends BaseTest {
	
	LoginPage lp;
	HomePage hp;
	UtilTest utl;
	ContactsPage cp;
	String sheetName ="contacts";
	
	
	public ContactsTest() {
		super();
	}
	
	// Testcases should be independent with other
	//before each test case- launch the browser and login
	//after each test case-close the browser
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		utl=new UtilTest();
		lp=new LoginPage();
		cp=new ContactsPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		utl.switchtoframe();
		cp=hp.clickoncontactslink();
	}
	
	
	@Test(priority=1)
	public void verifycontactspagelabel() {
		Assert.assertTrue(cp.verifycontactslabel(),"Contacts label is missing");
	}
	
	@Test(priority=2)
 	public void selectcontactstest() {
		cp.selectcontactsbyname("arjun lohit");
	}
	
	@DataProvider
	public Object[][] getdataTest() {
		Object data[][]=UtilTest.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=3, dataProvider="getdataTest")
	public void validatecontacts(String title,String firstname,String LastName,String company) {
		
		hp.clickoncontacts();
	//	cp.createNewContacts("Mr.", "Arjun", "lohit", "Cognizant");
		cp.createNewContacts(title, firstname, LastName, company);
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}

}
