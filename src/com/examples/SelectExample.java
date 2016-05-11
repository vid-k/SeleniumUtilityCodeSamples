package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample {

	static void selectEx()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Vidya/Desktop/WhiteboxQA_Innovapath_Training_mynotes/Java/workspace/FrameworkExample/select.html");
		WebElement elem = driver.findElement(By.name("Mobiles"));
		Select sel = new Select(elem);
		sel.selectByVisibleText("Nokia");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		sel.selectByVisibleText("Motorola");
	}
	
	public static void main(String[] args) {
		SelectExample.selectEx();
	}
	
}
