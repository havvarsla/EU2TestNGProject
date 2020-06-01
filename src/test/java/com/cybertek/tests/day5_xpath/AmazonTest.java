package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * go to amazon.com
         * search for selenium
         * click search button
         * print 1-48 of 304 results for "selenium"
         *
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        WebElement searchInputBox = driver.findElement(By.id("twotabsearchtextbox"));
        String input = "java";
        Thread.sleep(2000);
        searchInputBox.sendKeys(input);
        WebElement searchButton = driver.findElement((By.xpath("//input[@type='submit']")));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("searchResult "+ searchResult.getText());

        searchInputBox.sendKeys("Toys for 8 years");
        Thread.sleep(2000);
        searchButton.click();

        searchInputBox.sendKeys("Serum for hair");
        Thread.sleep(2000);
        searchButton.click();
    }
}
