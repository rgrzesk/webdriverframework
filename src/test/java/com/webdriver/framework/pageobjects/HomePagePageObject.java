package com.webdriver.framework.pageobjects;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.webdriver.framework.global.BBC;


public class HomePagePageObject extends LoadableComponent<HomePagePageObject>{

	public WebDriver driver;
	
	
	private static final String FEATURE_CONTAINER_ID = "features-and-analysis-2";
	private static final String FEATURE_CLASS = "features-header";
	private static String clickedLink = "";
	
	@FindBy(className = FEATURE_CLASS)
	private WebElement feature;
	
	@FindBy(css = "div#"+FEATURE_CONTAINER_ID+" ul li")
	private List<WebElement> featureList;
	
	@FindBy(css = "ul#blq-nav-main li a")
	private List<WebElement> tabList;
	
	public boolean isFeatureDisplayed(){
		return feature.isDisplayed();
	}
	
	public int getFeatureNumber(){
		return featureList.size();
	}
	
	public boolean areThumbnailsExist(){
		for(WebElement element : featureList){
			String src = element.findElement(By.cssSelector("h3 a img")).getAttribute("src");
			if(!StringUtils.isNotBlank(src) || !element.findElement(By.cssSelector("h3 a img")).isDisplayed())
			{
				return false;
			}
		}
		return true;
	}
	
	public HomePagePageObject clickOnFeature(int featureNumber){
		WebElement featureToBeClicked = featureList.get(featureNumber).findElement(By.cssSelector("a"));
		clickedLink = featureToBeClicked.getAttribute("href");
		featureToBeClicked.click();
		return this;
	}
	
	public boolean isUserRedirectedToCorrectPage(){
		String currentUrl = driver.getCurrentUrl();
		return (clickedLink).equals(currentUrl);
	}
	
	public HomePagePageObject clickOnTab(String tabName, String title){
		for(WebElement tabs : tabList){
			if(tabName.equals(tabs.getText()))
			{
				tabs.click();
				new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs(title));
				break;
			}
		}
		return this;
	}
	
	
	
	
	public HomePagePageObject(WebDriver webDriver) {
		driver = webDriver;
        PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() {
		String title = driver.getTitle();
		Assert.assertEquals(title, BBC.BBC_NEWS_TITLE);
	}

	@Override
	protected void load() {
		driver.get(BBC.BBC_NEWS_URL);
	}
	

}
