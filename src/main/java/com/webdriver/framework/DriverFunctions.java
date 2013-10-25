package com.webdriver.framework;

import org.openqa.selenium.WebDriver;

public class DriverFunctions {
	
	private WebDriver driver;
	
	
	public DriverFunctions(WebDriver driver){
		this.driver = driver;
	}
	
	public void refreshPage(){
		driver.navigate().refresh();
	}
	

}
