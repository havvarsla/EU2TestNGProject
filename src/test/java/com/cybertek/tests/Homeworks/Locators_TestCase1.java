package com.cybertek.tests.Homeworks;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class Locators_TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.com/");

        driver.findElement(By.id("gh-ac")).sendKeys("computer");

        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(7000);

        WebElement result = driver.findElement(By.xpath("//h1[contains(text(), 'results for')]"));

        System.out.println("result = " + result.getText());
    }
}

