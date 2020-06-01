package com.cybertek.tests.Homeworks.Homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase9_12 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterClass
    public void afterMethod() throws InterruptedException {
        // Thread.sleep(3000);
        // driver.quit();
    }

    @DataProvider(name = "status code")
    public Object[][] createData1(){
        return new Object[][]{
                {"200"},
                {"301"},
                {"404"},
                {"500"},
        };
    }

    @Test(dataProvider = "status code")
    public void TestCase9(String status ){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText(status)).click();

        String actualResult = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(actualResult.contains("This page returned a " + status + " status code."));
        System.out.println("actualResult: " + actualResult);

    }



}
