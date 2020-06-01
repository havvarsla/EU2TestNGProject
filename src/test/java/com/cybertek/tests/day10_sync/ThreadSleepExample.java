package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ThreadSleepExample {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/dynamic_loading/3");

        Thread.sleep(5000);

        driver.findElement(By.id("username")).sendKeys("Mike Smith");

    }
}
