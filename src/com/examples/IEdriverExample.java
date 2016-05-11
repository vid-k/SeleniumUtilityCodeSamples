package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class IEdriverExample {

	static void actionsEx() {
		
		System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		ieCapabilities.setCapability
			(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		WebDriver driver = new InternetExplorerDriver(ieCapabilities);
		
		driver.get("http://www.ebay.com");
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		Actions ac = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Fashion"));
		ac.moveToElement(element).clickAndHold().build().perform();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		
		//expecting http://www.ebay.com/rpp/fashion-main
		System.out.println("On clicking Fashion, the current URL is " + driver.getCurrentUrl());
		driver.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEdriverExample.actionsEx();		
	}

}
