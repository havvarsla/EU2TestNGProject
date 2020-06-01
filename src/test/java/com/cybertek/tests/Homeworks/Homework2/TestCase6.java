package com.cybertek.tests.Homeworks.Homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
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

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        WebElement copyEmail = driver.findElement(By.id("email"));
        String email = copyEmail.getText();
       //System.out.println(email);
        Thread.sleep(3000);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Sign Up For")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("full_name")).sendKeys("Hansel");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.tagName("h3")).getText();
        System.out.println(actual);
        Assert.assertEquals(expected, actual, "Verify the message is displayed ");
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement dontReply = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail:nth-of-type(1)"));
        Assert.assertTrue(dontReply.isDisplayed(), "Verify the email displayed");
        System.out.println("dontReply.isDisplayed(): " + dontReply.isDisplayed());
        Thread.sleep(2000);
        dontReply.click();
//
//        WebElement thanxMessage = driver.findElement(By.className("predmet pull-left"));
//
//        Assert.assertTrue(thanxMessage.isDisplayed(), "Verify the message for thanx displayed");
//        System.out.println("thanxMessage.isDisplayed() "+ thanxMessage.isDisplayed());

       }
}
