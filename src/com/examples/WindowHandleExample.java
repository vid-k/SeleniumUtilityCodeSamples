package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandleExample {

	//Example of pininterest child window
	static void windowHandleEx1()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.pinterest.com/");
		String child  = driver.getWindowHandle();
		driver.switchTo().window(child);
		driver.findElement(By.id("userEmail")).sendKeys("asdasdas");
		driver.quit();
	}
	
	//Example of WBL Facebook login window
	static void windowHandleEx2() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://whiteboxqa.com/");
		driver.manage().window().maximize();
		
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		//Perform the click operation that opens new window
		driver.findElement(By.id("headerfblogin")).click();
		
		//Switch to new window opened
		for(String winHandle1 : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle1);
		}
		
		//Perform the actions on new window
		System.out.println("Facebook window title is: " + driver.getTitle());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("abc.gmail.com");
		driver.findElement(By.id("u_0_2")).click(); 
		driver.findElement(By.linkText("Having trouble?")).click();
		
		//Close the windowHandle1 window, since we don't need it anymore
		//driver.close(); //why does this give error?
				
		//Switch to new window opened
		for(String winHandle2 : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle2);
		}
		System.out.println("Forgot Password window title is: " + driver.getTitle());
		driver.findElement(By.id("u_0_b")).click();
		
		//Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		//Continue with original browser (first window)
		System.out.println("Logo on WBL hompage is displayed?: " + driver.findElement(By.id("logo")).isDisplayed());
		
		//quit() should close all remaining windows
		//driver.close();
		driver.quit();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WindowHandleExample.windowHandleEx1();
		WindowHandleExample.windowHandleEx2();
	}

}


