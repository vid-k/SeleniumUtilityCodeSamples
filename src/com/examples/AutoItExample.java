package com.MockPreps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoItExample {

    @Test
    public void testAutoIt() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Vidya/Desktop/WhiteboxQA_Innovapath_Training_mynotes/Java/workspace/FrameworkExample/fileupload.html");
        driver.findElement(By.id("F1")).click();
                
        try {
        	Runtime.getRuntime().exec("C:\\Users\\Vidya\\fileupload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.quit();
    }
}
