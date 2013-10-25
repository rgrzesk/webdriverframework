package com.webdriver.framework.tests;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webdriver.framework.base.SetupTest;
import com.webdriver.framework.pageobjects.HomePagePageObject;

public class HomePageTabsTest extends SetupTest{

	@DataProvider(name = "Data-provider-tabs")
	public Object[][] dataProviderTabs()
	{
		return new Object[][]
				{
					{"News", "BBC News - Home"},
					{"Sport", "BBC Sport - Sport"},
					{"Weather", "BBC Weather"}
				};
	}
	
	
	@Test(dataProvider = "Data-provider-tabs")
	public void navigatingBetweenTabs(String tabName, String title){
		HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
		homePagePageObject.get()
						.clickOnTab(tabName, title);
		Assert.assertEquals(title, driver.getTitle());
	}
	
}
