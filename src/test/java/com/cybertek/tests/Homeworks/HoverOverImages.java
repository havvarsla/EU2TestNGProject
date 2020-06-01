package com.cybertek.tests.Homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverOverImages {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
//        driver.quit();
    }
    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void Test() throws InterruptedException {
        List<WebElement> images =  driver.findElements(By.tagName("img"));
        System.out.println("images.size()=" +images.size());
        Actions actions = new Actions(driver);
        Assert.assertEquals(images.size(), 3);
        int i=1;
        for (WebElement img : images) {
            actions.moveToElement(img).perform();
            Thread.sleep(2000);
//            WebElement image = driver.findElement(By.className("figcaption"));
//            WebElement name = image.findElements(By.tagName("h5")).get(i);
            WebElement name = driver.findElement(By.xpath("(//h5)["+i+"]"));
            System.out.println("text"+i+":"+name.getText());
            String expected = "name: user" + i;
            Assert.assertEquals(name.getText(), expected);
           i++;
        }

    }
}
