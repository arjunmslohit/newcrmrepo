package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest{ 
	LoginPage lp;
	HomePage hp;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	   lp=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
	String title= lp.ValidateTitle();
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	
		
	}
	
	@Test(priority=2)
	public void CrmLogoImageTest() {
		boolean flag=lp.ValidateCrmImage();
		Assert.assertTrue(flag);
		
		
	}
	@Test(priority=3)
	public void LoginTest() {
		
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}

}
