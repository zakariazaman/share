package com.sample.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.sample.pages.IndexPage;

public abstract class BaseTest
{
	private static Logger log = Logger.getLogger(BaseTest.class.getName());
	
	//This browser object will be shared across the framework
	public WebDriver browser;
	
	
	@Before
	public void startBrowser()
	{
		DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");
		browser = new FirefoxDriver(); 
		log.info("browser is initialized ");
		browser.get("http://www.viasnella.com");
		String url = browser.getCurrentUrl();
		System.out.println(url);
		
	}
	 
	
	@After
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(3000);
		
		// Quit the browser after each test
		browser.quit();
		log.info("Quit the browser after each test");
	}
	
		 

}
