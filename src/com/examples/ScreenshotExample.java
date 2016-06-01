package com.MockPreps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotExample {

    public static File screenshot(WebDriver driver) {
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcfile.getAbsolutePath());
        return srcfile;
    }

    public static String getFormattedDate() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
        System.out.println(f.format(new Date()).toString());
        return f.format(new Date()).toString();
    }

    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.whiteboxqa.com");
        File srcfile = screenshot(driver);
        String date = getFormattedDate();
        System.out.println(System.getProperty("user.dir"));
        String targetfilepath = System.getProperty("user.dir")+"/Screenshot"+"_"+date+".png";
        try {
            FileUtils.copyFile(srcfile, new File(targetfilepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
