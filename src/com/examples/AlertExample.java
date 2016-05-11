package com.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertExample {

	static void alertEx1() throws InterruptedException
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Vidya/Desktop/WhiteboxQA_Innovapath_Training_mynotes/Java/workspace/FrameworkExample/alert.html");
		((JavascriptExecutor)driver).executeScript("myFunction()");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();
		driver.close();
	}

	static void alertEx2() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Vidya/Desktop/WhiteboxQA_Innovapath_Training_mynotes/Java/workspace/FrameworkExample/confirmAlert.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
		driver.findElement(By.cssSelector("button[onclick='confirmFunction()']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.dismiss();
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AlertExample.alertEx1();
		AlertExample.alertEx2();

	}

}
