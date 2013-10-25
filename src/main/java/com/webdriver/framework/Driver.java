package com.webdriver.framework;

import org.openqa.selenium.WebDriver;


public class Driver {
    
    public WebDriver get() throws Exception{
    	try{
    		System.err.println(System.getProperty("browser"));
    		if("FF".equals(System.getProperty("browser"))) {
				new DriverCreator();
				return DriverCreator.getFirefoxDriver();
			} else if("Chrome".equals(System.getProperty("browser"))) {
				new DriverCreator();
				return DriverCreator.getChromeDriver();
			} else {
				new DriverCreator();
				return DriverCreator.getChromeDriver();
			}
    		} 
    		catch(Exception e)
    		{	
    			throw e;
    		}
    	}
    
	}
	