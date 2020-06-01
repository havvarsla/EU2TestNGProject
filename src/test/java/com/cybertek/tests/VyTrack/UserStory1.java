package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
       Thread.sleep(6000);
//        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException {
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("user4");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        WebElement fleetGrid = driver.findElement(By.className("title-level-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetGrid).perform();
        Thread.sleep(2000);

        WebElement vehicle = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        actions.moveToElement(vehicle).click().perform();







    }

}