package com.MockPreps;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class CookiesExample {

    public static void cookies() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.whiteboxqa.com");
        	
        //Cookie name1 = new Cookie("myCookie1", "1234", "/", new Date(12, 12, 2016));
        //driver.manage().addCookie(name1);
        
        Cookie name2 = new Cookie("myCookie2", "5678");
        driver.manage().addCookie(name2);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies)
            System.out.println("Cookie name: "+c.getName() + " \nValue: " + c.getValue() + "\nPath: " + c.getPath() + " \nExpiry: " + c.getExpiry());
        driver.close();
    }

    public static void main(String args[]) {
        cookies();
    }
}
