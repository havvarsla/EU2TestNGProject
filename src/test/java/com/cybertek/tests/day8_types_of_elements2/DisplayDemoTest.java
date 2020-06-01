package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id ("username"));

        System.out.println("usernameInput.isDisplayed() = "+ usernameInput.isDisplayed());

        Assert.assertFalse(usernameInput.isDisplayed(), "Verify inputbox is not displayed");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(6000);

        Assert.assertTrue(usernameInput.isDisplayed(), "Verify inputbox is displayed");

    }
}
