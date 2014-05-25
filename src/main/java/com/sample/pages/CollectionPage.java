package com.sample.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CollectionPage 
{
	private WebDriver browser;
	private static Logger log = Logger.getLogger(CollectionPage.class.getName());
	
	@FindBy(how= How.XPATH, using="//a[@title='Ayumi // Green']//img")
	public WebElement firstProduct;
	
	
	public CollectionPage(WebDriver browser)
	{
		this.browser = browser; 
		PageFactory.initElements(browser, this);
		log.info("Visiting the collection page");
		
	}
	
	public void clickFirstProduct() throws Exception
	{
		firstProduct.click();
		Thread.sleep(2000);
		log.info("Clicked first product");
	}

}
