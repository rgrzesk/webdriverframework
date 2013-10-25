package com.webdriver.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCreator {
	
	private DriverCreator(){
		
	}
	
	public static FirefoxDriver getFirefoxDriver(){
		return new FirefoxDriver();
	}
	
	public static ChromeDriver getChromeDriver(){
        String currentDir = System.getProperty("user.dir");
		String chromeDriverLocation = currentDir + "/../tools/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);		
		return new ChromeDriver();
	}

}
