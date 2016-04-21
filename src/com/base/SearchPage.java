package com.base;

//Author : Vidhya Kasiviswanathan
//To search ebay page and retrieve the Prices for the first n items
//The search string and the number n are to be passed as a parameter from the TestNG.xml
//There is a corresponding test file - SearchPageTest.java
//This is a minimal implementaton for the purpose of an assignment dated 4/20/2016

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class SearchPage {

	public void SearchFunction (String searchString, int listCounter) {

		//Create a driver, launch ebay.com and enter a search
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ebay.com");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		System.out.println("NOTE: Parameterized searchString: " + searchString + " listCounter: " + listCounter);
		
		driver.findElement(By.id("gh-ac")).sendKeys(searchString);
		driver.findElement(By.id("gh-btn")).click();
		
		//The search results retrieve items and prices (css selector - li.lvprice.prc)
		//The price listings also have additional text (css selector - div.medprc)
		//For the purpose of displaying only the price, we need to write extra code
		List<WebElement> allLinks = driver.findElements(By.cssSelector("li.lvprice.prc"));
		List<String> allText = new ArrayList<String>();
		
		List<WebElement> childrenLinks = driver.findElements(By.cssSelector("div.medprc"));
		
		Iterator<WebElement> itrC = childrenLinks.iterator();		
		Iterator<WebElement> itrL = allLinks.iterator();
		
		int counter = 0; 
		while(itrL.hasNext() && counter < listCounter) 
		{
			if (itrC.hasNext())
				allText.add(itrL.next().getText().replace(itrC.next().getText(), ""));
			else 
				allText.add(itrL.next().getText());
				
			counter++;
		}
		 
		Iterator<String> itrT = allText.iterator();
		while (itrT.hasNext()) 
		{
			System.out.println("Price details: " + itrT.next());
		}
		 
		 driver.close();
	}
}


