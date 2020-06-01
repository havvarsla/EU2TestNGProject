package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioButtonTest1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //how to check is radio button selected ?
        System.out.println("blueRadioButton.isSelected() = "+ blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = "+ redRadioButton.isSelected());

        //Verify blue is selected red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "Verify Red is not selected");

        //How to select radio button?
        redRadioButton.click();

        //Verify blue is not selected red is selected
        Assert.assertTrue(redRadioButton.isSelected(),"Verify Red is selected");
        Assert.assertFalse(blueRadioButton.isSelected(), "Verify Blue is not selected");

        //driver.quit();

    }
}
