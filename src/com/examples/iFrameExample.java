package com.MockPreps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class iFrameExample {

    public static void frames() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.com/iframe-practice-page/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        List<WebElement> listofiframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes in the page: " + listofiframes.size());

        WebElement iframe1 = driver.findElement(By.id("IF1"));
        //((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoView();", iframe1);
        driver.switchTo().frame(iframe1);
        driver.findElement(By.cssSelector(".control-group input[name='firstname']")).sendKeys("test123");

        driver.switchTo().defaultContent();
        System.out.println("Controls back to default URL?: " + driver.getCurrentUrl());
        driver.findElement(By.linkText("DEMO SITES")).click();
        driver.close();

    }

    public static void main(String args[]) {
        frames();
    }
}
