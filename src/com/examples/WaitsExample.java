package com.MockPreps;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsExample {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.whiteboxqa.com");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        //explicit wait
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("@footerbot")));

        //fluent wait
        Wait fwait = new FluentWait(driver)
                .withTimeout(30,TimeUnit.MILLISECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = (WebElement) fwait.until(new Function() {
            @Override
            public Object apply(Object o) {
                WebDriver driver = (WebDriver)o;
                return driver.findElement(By.id("headerfblogin"));
            }
        });

    }

}
