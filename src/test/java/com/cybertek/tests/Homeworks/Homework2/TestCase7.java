package com.cybertek.tests.Homeworks.Homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/havva/Desktop/Whale.jpg");
        driver.findElement(By.id("file-submit")).click();
        WebElement fileUploded = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploded.isDisplayed(), "Verify File uploaded is displayed");
        System.out.println("fileUploded.isDisplayed(): " + fileUploded.isDisplayed());
  


    }
}
