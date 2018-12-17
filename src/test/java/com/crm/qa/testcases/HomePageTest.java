package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.UtilTest;


public class HomePageTest extends BaseTest {
	
	LoginPage lp;
	HomePage hp;
	UtilTest utl;
	ContactsPage cp;
	
	
	public HomePageTest() {
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
	}
	
	
	@Test(priority=1)
	public void verifyhomepagetitletest() {
		String homepagetitle=hp.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title is not matching");
		 
	}
	
	@Test(priority=2)
	public void verifyusernametest() {
	utl.switchtoframe();
	Assert.assertTrue(hp.verifyusername());
	}
	
	@Test(priority=3)
	public void verifycontactslink() {
		utl.switchtoframe();
		cp=hp.clickoncontactslink();
		
	}
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}

	
	
	
	
	
	

}
