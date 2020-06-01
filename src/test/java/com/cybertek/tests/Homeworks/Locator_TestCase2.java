package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator_TestCase2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://amazon.com");
        Thread.sleep(3000);
        driver.get("https://ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("headset");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        Thread.sleep(3000);

        String title = driver.getTitle();

        System.out.println("Title: " + title);

    }
}
