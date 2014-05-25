package com.sample.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.sample.browser.util.Shared;


public class IndexPage extends LoadableComponent<IndexPage>
{
	private static Logger log = Logger.getLogger(IndexPage.class.getName());
	
	private  WebDriver browser;
	private  LoadableComponent<?> parent;

	Shared sh = new Shared(browser);
		
	// Find all the element in this page
	@FindBy(how= How.XPATH, using="//a[@id='theshop']")
	private WebElement theShop;
	
	@FindBy(how= How.ID, using="theshop")
	private WebElement theShopById;
		
	@FindBy(how=How.ID, using="thestory")
	private WebElement theStory;
	
	@FindBy(how=How.ID, using="thenews")
	private WebElement theNews;
	
	@FindBy(how= How.XPATH, using="//li[@id='visittheshop']/h2/a")
	private WebElement visitShop;
	
	@FindBy(how= How.XPATH, using="//li[@id='readthestory']/h2/a")
	private WebElement readStory;
	
	@FindBy(how= How.XPATH, using="//li[@id='readthenews']/h2/a")
	private WebElement readNews;
	
	
	public IndexPage(WebDriver browser)
	{
		this.browser = browser; 
		PageFactory.initElements(browser, this);
		log.info("Visiting index page");
		
	}
	

	public void clickTheShopLink() throws Exception
	{
		if(sh.isElementPresent(theShop))
		{
			theShop.click();
			Thread.sleep(2000);
			log.info("Click Shop link");
				
		}
		
		else if(sh.isElementPresent(theShopById))
		{
			theShop.click();
				
		}			
		
	}
	
	public void clickvisitShopLink()
	{
		if(sh.isElementPresent(visitShop))
		{
			visitShop.click();
				
		}		
		
	}
	
	public void clickreadthestoryLink()
	{
		if(sh.isElementPresent(readStory))
		{
			readStory.click();
				
		}		
		
	}
	public void clickTheStoryLink()
	{
		if(sh.isElementPresent(readNews))
		{
			readNews.click();
				
		}		
		
	}
	
	public void clickreadNewsLink()
	{
		if(sh.isElementPresent(theStory))
		{
			theStory.click();
				
		}		
		
	}
	public void clickTheNewsLink()
	{
		if(sh.isElementPresent(theNews))
		{
			theNews.click();
				
		}		
		
	}

	@Override
	protected void load() {
		
		log.info("I am from load method");
		browser.get("http://www.facebook.com/");
//		browser.get("http://www.viasnella.com/");
		
	}

	@Override
	protected void isLoaded() throws Error {
		 String actualURL = browser.getCurrentUrl();
		 String expectedURL = "http://www.viasnella.com/";
		 assertTrue("Not on the issue entry page: " + actualURL, actualURL.endsWith("/new"));
//		 Assert.assertTrue("Not on the issue entry page: " + actualURL, "http://www.viasnella.com/");
		// Assert.assertEquals(actualURL, expectedURL); 
		 log.info("End of isLoaded method");
	}


	

}
