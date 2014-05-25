package com.sample.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class TheShopPage extends LoadableComponent<TheShopPage> 
{
	private WebDriver browser;
	private static Logger log=Logger.getLogger(TheShopPage.class.getName());
	
	// this will store all the link images in a List type variable
	@FindBy(how= How.XPATH, using="//table[@id='gallery']//a//img")
	private List<WebElement> products;
	
	public TheShopPage(WebDriver browser)
	{
		this.browser = browser;
		//it will initiate all the elements/services in this page at the time of object creation
		PageFactory.initElements(browser, this);
		log.info("Visiting the shop page");
	}
	
	public void clickEachElement() throws Exception
	{
		System.out.println("Total size"+products.size());
		for(int i=0;i<products.size();i++)
		{
			
			Thread.sleep(2000);
			products.get(i).click();
			Thread.sleep(2000);
			browser.navigate().back();
			Thread.sleep(2000);
			
		}
		
	}

	@Override
	protected void load() 
	{
		
		browser.get("http://www.viasnella.com/collections/new");
		 String actualURL = browser.getCurrentUrl();
		 System.out.println(actualURL);
		log.info("I am from ShopPage Load Method");
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
