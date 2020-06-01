package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cybertekschool.com");
        Thread.sleep(2000);
////    close only current page
       driver.close();

        driver = new ChromeDriver();


        driver.get("https://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(10000);

        //close all tabs one or more
        driver.quit();


    }
}