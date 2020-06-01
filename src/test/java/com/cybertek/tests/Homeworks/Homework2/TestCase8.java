package com.cybertek.tests.Homeworks.Homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {

    @Test
    public void test(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        WebElement selected = driver.findElement(By.id("result"));
        Assert.assertTrue(selected.isDisplayed(), "Verify you selected message displayed");
        System.out.println("selected.isDisplayed(): "+ selected.isDisplayed());
    }
}
