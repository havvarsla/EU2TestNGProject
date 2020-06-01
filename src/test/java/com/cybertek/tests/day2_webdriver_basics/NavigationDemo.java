package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        //setting up chrome driver for autmation
        WebDriverManager.chromedriver().setup();
        //creating driver object for chrome
        WebDriver driver = new ChromeDriver();

        //navigate the method
        driver.get("https://www.google.com");
        Thread.sleep(3000);

        //navigate
        driver.navigate().to("https://www.facebook.com");

        //wait 3s here then go back
        Thread.sleep(3000);
        //how to go back to google afterwe navigate to facebook
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();
    }
}
