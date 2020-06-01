package com.cybertek.tests.day11_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath + "/"+relativePath;
        chooseFile.sendKeys(filePath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        System.out.println("projectPath user.dir = "+ projectPath);
        //getting name of the file
        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFilename,"Text.txt");
    }
}
