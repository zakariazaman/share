package com.sample.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.sample.pages.AboutUsPage;
import com.sample.pages.BlogNewsPage;
import com.sample.pages.CollectionPage;
import com.sample.pages.IndexPage;
import com.sample.pages.TheShopPage;

public  class SmokeTest extends BaseTest
{
	private static Logger log = Logger.getLogger(SmokeTest.class.getName());
	
	IndexPage hPage ;
	CollectionPage cPage;
	AboutUsPage aUsPage;
	BlogNewsPage bnPage;
	TheShopPage shPage;
	
	
	@Test
	public void purchase() throws Exception
	{
		log.info("================================");
		log.info("Purchse test started");
		log.info("================================");

		hPage = new IndexPage(browser);
		hPage.get();
		
		
		hPage.clickTheShopLink();
		shPage = new TheShopPage(browser);
		shPage.get();
		Thread.sleep(3000);
		shPage.clickEachElement();
		
		log.info("================================");
		log.info("Purchse test ended");
		log.info("================================");
	}
	@Ignore
	@Test
	public void collectionTest() throws Exception
	{
		log.info("================================");
		log.info("CollectionTest test started");
		log.info("================================");
		
//		hPage = new IndexPage(browser);
		hPage.clickTheShopLink();
//		cPage = new CollectionPage(browser);
//		cPage.clickFirstProduct();		
//		
		log.info("================================");
		log.info("CollectionTest test ended");
		log.info("================================");
	}

	
	
	

}
