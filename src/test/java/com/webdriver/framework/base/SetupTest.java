package com.webdriver.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.webdriver.framework.Driver;
import com.webdriver.framework.DriverFunctions;

public class SetupTest{

	protected static WebDriver driver;
	protected DriverFunctions functions;

	@BeforeMethod
	public void startSelenium() throws Exception 
	{
		driver = new Driver().get();
		functions = new DriverFunctions(driver);
	}

	
	@AfterMethod(alwaysRun=true)
	public void stopSelenium() throws Exception
	{		
		if (driver != null)
		{
			driver.quit();
		}
	}


}
