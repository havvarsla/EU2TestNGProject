package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
         driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterClass
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test(){
         driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
         driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

         //Locate and click No button
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //locate click the  Clicck for js alert button
        driver.findElement(By.xpath("//button[1]")).click();
        //Switch to JS alert windows
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        //Click on click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        //Click for JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("Mike Smith");
        alert.accept();
    }
}
