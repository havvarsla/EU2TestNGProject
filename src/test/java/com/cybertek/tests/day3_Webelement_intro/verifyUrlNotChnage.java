package com.cybertek.tests.day3_Webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChnage {
    public static void main(String[] args) {
        /**
         * open chrome browser
         *  * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         *  * click on Retrieve password
         *  * verify that url did not change
         */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/forgot_password");

        //Save the url before we click
        String currentUrl = driver.getCurrentUrl();

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //clicking web element
        retrievePasswordButton.click();

        //Verify that url did not change

        //We save the url after we click button
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(currentUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        //close browsers
        driver.quit();

    }
}
