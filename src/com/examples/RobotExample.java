package com.MockPreps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotExample {

    public static void main(String args[]) throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.gmail.com");
        driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
        //driver.findElement(By.id("Passwd")).sendKeys("abc123");
        Robot robo = new Robot();
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        driver.quit();
    }
}
