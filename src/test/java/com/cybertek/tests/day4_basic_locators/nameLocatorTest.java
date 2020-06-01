package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //make browser Full Screen
        driver.manage().window().fullscreen();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("test@gmail.com");

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        WebElement actualConfirmationMessage = driver.findElement(By.name("signup_message"));
        //save expected message that is defined in the test case
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        //save actual message that is coming from browser
        String actualMessage = actualConfirmationMessage.getText();
        //verify
        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }
        //close the browser
        driver.quit();
    }
}
