package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class playground {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void JasonInfo() {
        for (int i = 1; i <= 6; i++) {
            WebElement personInfo = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[" + i + "]"));
            System.out.print(personInfo.getText() + "|");
        }

    }

    @Test
    public void firstTable() {
        int numberOfRows = getNumberOfRows();
        int numberOfColumns = getNumberOfColumns();
        System.out.println(numberOfColumns);
        getHeadInfo();
    }

    private void getHeadInfo() {
        for (int i = 1; i <= getNumberOfColumns(); i++) {
            WebElement headers = driver.findElement(By.xpath("//table[@id='table1']/thead//th[" + i + "]"));
            System.out.print(headers.getText() + " | ");
        }
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows.size();
    }

    @Test
    public void getAllRows() {
        for (int i = 1; i <= getNumberOfRows(); i++) {
            for (int j = 1; j <= getNumberOfColumns(); j++) {
                WebElement info = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.print(info.getText() + " | ");
            }
            System.out.println();
        }
        //
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("storemanager53");
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        WebElement logInButton = driver.findElement(By.cssSelector("[type='submit']"));
        logInButton.click();
        Thread.sleep(6000);
        WebElement fleetGrid = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetGrid).perform();

        List<WebElement> dropdownitems = driver.findElements(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li"));
        //System.out.println(dropdownitems.size());
        for (int i = 1; i <= dropdownitems.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[" + i + "]"));
            if (row.getText().contains("Costs")) {
                actions.moveToElement(row).click().perform();
            }
        }


    }
}
