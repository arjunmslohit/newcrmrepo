package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.ListenerWebEvent;
import com.crm.qa.util.UtilTest;


public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static ListenerWebEvent eventListener;
	
	
	
	
	public BaseTest() {
		
		prop=new Properties();
		try {
			FileInputStream fp=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}
	  
	
	  public static void initialization() {
		  
		String browsername= prop.getProperty("browser");
		System.out.println("THE BROWSER NAME IS"+browsername);
		String name=prop.getProperty("username");
		System.out.println("THE NAME IS "+name);
		String pass=prop.getProperty("password");
		System.out.println("THE PASSWORD IS "+pass);
		 if(browsername.equals("chrome")) {
			 
			 System.setProperty("webdriver.chrome.driver", "D:/selenium drivers/Chrome/chromedriver.exe");
			 driver=new ChromeDriver();
			 
		 }
		 
		 e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new ListenerWebEvent();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
		    driver.get(prop.getProperty("url"));
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().pageLoadTimeout(UtilTest.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(UtilTest.IMPLICITLY_WAIT,TimeUnit.SECONDS);
		    
		   // driver.get(prop.getProperty("url"));
		  	  
	  }


}



