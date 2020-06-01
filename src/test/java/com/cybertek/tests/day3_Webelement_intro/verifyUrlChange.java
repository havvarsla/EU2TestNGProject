package com.cybertek.tests.day3_Webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChange {
    public static void main(String[] args) {
        /**
         *   Verify confirmation message
         *          * open browser
         *          * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         *          * enter any email
         *          * verify that email is displayed in the input box
         *          * click on Retrieve password
         *          * verify that confirmation message says 'Your e-mail's been sent!'
         *          */

        //driver represent the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //Enter any email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("test@gmail.com");

        WebElement retrieveButton = driver.findElement(By.id("format_submit"));
        retrieveButton.click();

        String  currentUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(currentUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("CurrentUrl: "+ currentUrl);
            System.out.println("ActualUrl: "+ actualUrl);
        }

        driver.quit();

    }
}
