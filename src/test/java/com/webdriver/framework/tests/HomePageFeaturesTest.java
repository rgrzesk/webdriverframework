package com.webdriver.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webdriver.framework.base.SetupTest;
import com.webdriver.framework.pageobjects.HomePagePageObject;

public class HomePageFeaturesTest extends SetupTest{
	
   @Test
   public void homePageFeatures(){

	HomePagePageObject homePageFeaturesSection = new HomePagePageObject(driver);
	homePageFeaturesSection.get();
	Assert.assertTrue(homePageFeaturesSection.isFeatureDisplayed());
	Assert.assertEquals(homePageFeaturesSection.getFeatureNumber(),	7);
	Assert.assertTrue(homePageFeaturesSection.areThumbnailsExist());
	homePageFeaturesSection.clickOnFeature(4);
	Assert.assertTrue(homePageFeaturesSection.isUserRedirectedToCorrectPage(), 
			"Checking if user is redirected to correct page");
   }	

   
}
