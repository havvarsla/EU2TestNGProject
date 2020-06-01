package com.cybertek.tests.Homeworks.Homework2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class TestCase1_5 {
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
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationform = driver.findElement(By.linkText("Registration Form"));
        registrationform.click();
        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("13/19/2021");
        WebElement invalidDob = driver.findElement(By.xpath("//small[@data-bv-validator = 'date']"));
        Assert.assertTrue(invalidDob.isDisplayed(), "Verify the date of birth is not valid");
        System.out.println("invalidDob.isDisplayed "+ invalidDob.isDisplayed());
        
    }

    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationform = driver.findElement(By.linkText("Registration Form"));
        registrationform.click();
        WebElement c = driver.findElement(By.id("inlineCheckbox1"));
        WebElement j = driver.findElement(By.id("inlineCheckbox2"));
        WebElement js = driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(c.isDisplayed(), "Verify that c++ is displayed");
        Assert.assertTrue(j.isDisplayed(), "Verify that java is displayed");
        Assert.assertTrue(js.isDisplayed(), "Verify that javascript is displayed");
        System.out.println("c.isDisplayed "+ c.isDisplayed());
    }

    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationform = driver.findElement(By.linkText("Registration Form"));
        registrationform.click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("A");
        WebElement invalidInput = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));
        Assert.assertTrue(invalidInput.isDisplayed(), "Verify the message for first name displayed");
        System.out.println("invalidInput.isDisplayed() "+ invalidInput.isDisplayed());
    }


    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationform = driver.findElement(By.linkText("Registration Form"));
        registrationform.click();
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("A");
        WebElement invalidInput = driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]"));
        Assert.assertTrue(invalidInput.isDisplayed(), "Verify the message for lastname displayed");
        System.out.println("invalidInput.isDisplayed() "+ invalidInput.isDisplayed());
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationform = driver.findElement(By.linkText("Registration Form"));
        registrationform.click();
        driver.findElement(By.name("firstname")).sendKeys("Hansel");
        driver.findElement(By.name("lastname")).sendKeys("Gratel");
        driver.findElement(By.name("username")).sendKeys("SeaSide");
        driver.findElement(By.name("email")).sendKeys("sea@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234havali");
        driver.findElement(By.name("phone")).sendKeys("571-000-7890");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("12/11/1990");

        WebElement dropdownElement = driver.findElement(By.cssSelector("select[name='department']"));
        Select departmentDropdown = new Select(dropdownElement);
        Thread.sleep(3000);
        departmentDropdown.selectByVisibleText("Tourism Office");

        WebElement dropDownJob = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select jobDropdown = new Select(dropDownJob);
        Thread.sleep(2000);
        jobDropdown.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement weldone = driver.findElement(By.cssSelector(".alert-heading"));
        Assert.assertTrue(weldone.isDisplayed(), "Verify Weldone messsage is displayed");
        System.out.println("weldone.isDisplayed() " + weldone.isDisplayed());

    }

}
