package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("selenium webdriver");

        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
        Thread.sleep(3000);
        String currentUrl =  "https://en.wikipedia.org/wiki/Selenium_(software)";

        WebElement searchResult = driver.findElement(By.xpath("//a[@title='Selenium (software)']"));
        searchResult.click();
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();


        if(actualUrl.equals(currentUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("CurrentUrl: "+ currentUrl);
            System.out.println("ActualUrl: "+ actualUrl);
        }



    }
}
