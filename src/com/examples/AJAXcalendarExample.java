package com.MockPreps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AJAXcalendarExample {

    public static void ajaxControls() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demos.telerik.com/aspnet-ajax/" +
                "ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".demo-container")));

        //get text before selecting a date
        WebElement dateBefore = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
        System.out.println(dateBefore.getText());

        //get text after selecting a date
        driver.findElement(By.linkText("16")).click();

        //Wait for loader to disappear
        By loader = By.className("raDiv");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		//Get the text after ajax call - using Explicit wait
        WebElement selectedDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
        wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
        String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
        System.out.println(textAfterAjaxCall);
    }

    public static void main(String args[]) {
        ajaxControls();
    }
}

