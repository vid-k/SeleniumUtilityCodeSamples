package com.MockPreps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadExample {

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.freeonlinephotoeditor.com/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath(".//*[@id='fileForm']/div/span[1]/span/input")).click();
        try {
            Runtime.getRuntime().exec("C:/Users/Sampath/upload.exe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
