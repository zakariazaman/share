package com.sample.browser.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sample.test.BaseTest;

public class Shared 
{
	private static Logger log = Logger.getLogger(BaseTest.class.getName());
	private WebDriver browser;

	public Shared(WebDriver browser) 
	{
		this.browser = browser;
	}
	
	public boolean isElementPresent(WebElement ele)
	{
		try
		{
			ele.isDisplayed();
			return true;
		}
		catch(NoSuchElementException e)
		{
			log.error(e);
			return false;
		}
			
	}
	
	public boolean isElementPresent(By by)
	{
		try
		{
			browser.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			log.error(e);
			return false;
		}
			
	}
	
	

}
