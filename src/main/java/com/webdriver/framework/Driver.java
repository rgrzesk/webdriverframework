package com.webdriver.framework;

import org.openqa.selenium.WebDriver;


public class Driver {
    
	public enum Browsers{
    	FF,
    	CHROME
    }

	private WebDriver getChromeDriver()
	{
		return DriverCreator.getChromeDriver();
	}
	
    public WebDriver get() throws Exception{
    	Browsers browser = Browsers.valueOf(System.getProperty("browser"));
    	
    	switch (browser){
    	case FF:
			return DriverCreator.getFirefoxDriver();
    	case CHROME: 
			return getChromeDriver();
		default: 
			return getChromeDriver();
    	
    	}
    
    }
}
	