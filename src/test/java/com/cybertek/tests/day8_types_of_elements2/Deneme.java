package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Deneme {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

       WebElement simpleDropdown = driver.findElement(By.id("dropdown"));

       Select dropdown = new Select(simpleDropdown);
       String expetedone = "Please Select an option";
       String actualone = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expetedone,actualone , "Verify that are equal");
        System.out.println("Droppp===" + dropdown.getFirstSelectedOption().getText());


    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement languageDropdown = driver.findElement(By.cssSelector("select[name='Languages']"));


        Select languageDropdownO = new Select(languageDropdown);
        languageDropdownO.selectByIndex(2);

        WebElement selectWebsite = driver.findElement(By.cssSelector("div[class='dropdown-menu']"));
        Select selectWebs = new Select(selectWebsite);

        selectWebs.selectByVisibleText("Amazon");

    }
}
