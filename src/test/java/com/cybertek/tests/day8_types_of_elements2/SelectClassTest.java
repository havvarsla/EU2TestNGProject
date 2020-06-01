package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        //Verify first selection is Slect a state
        String expectedOption = "Select a State";
        String actualSelection = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, expectedOption, "Verify first selection");

        //How to Select options from dropdown
        //1.Select Using Visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Texas");
        String expectedOptions = "Texas";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOptions);
        Thread.sleep(4000);

        //2.Select Using By index
        stateDropdown.selectByIndex(51);
        expectedOptions = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOptions);
        Thread.sleep(2000);

        //3.Select using by Value
        Thread.sleep(2000);
        stateDropdown.selectByValue("DC");
        expectedOption = "District Of Columbia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);
    }
}
