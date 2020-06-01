package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        //get title
        System.out.println("Title before new window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = "+ windowHandles.size());

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }

        }
        System.out.println("Title after new window: " + driver.getTitle());
        //if you want to get
        driver.switchTo().window(currentWindowHandle);
        System.out.println(driver.getTitle());

    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Before switch "+ driver.getTitle());
        //Loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            //Whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }
        System.out.println("After switch "+ driver.getTitle());
        driver.findElement(By.tagName("h3"));
    }
}
