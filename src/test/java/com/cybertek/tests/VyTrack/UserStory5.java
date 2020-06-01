package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory5 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(6000);
//        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("user4");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

         Thread.sleep(3000);
         WebElement fleetGrid = driver.findElement(By.className("title-level-1"));
         Actions actions = new Actions(driver);
         actions.moveToElement(fleetGrid).perform();
         Thread.sleep(3000);
         WebElement vehicleCost = driver.findElement(By.xpath("//span[text()='Vehicle Costs']"));
         actions.moveToElement(vehicleCost).click().perform();

    }

    @Test
    public void test2() throws InterruptedException {
        test1();
        Thread.sleep(2000);
        WebElement createCost = driver.findElement(By.linkText("Create Vehicle Costs"));
        Thread.sleep(3000);
        createCost.click();

        driver.findElement(By.xpath("//span[@class='select2-arrow']")).click();
        Thread.sleep(2000);
        WebElement chooseAValue = driver.findElement(By.name("custom_entity_type[Type]"));
        Select selectValue = new Select(chooseAValue);
        selectValue.selectByVisibleText("Vehicle Insurance");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='custom_entity_type[TotalPrice]']")).sendKeys("3000");
        driver.findElement(By.xpath("//input[@placeholder='Choose a date']")).sendKeys("May 15, 2020");

        Actions actions = new Actions(driver);

        Thread.sleep(4000);

        WebElement save1= driver.findElement(By.xpath("//div[@class='pull-right']/div/div[2]//li[1]"));
        actions.moveToElement(save1).click().build().perform();

//        WebElement saveClose =  driver.findElement(By.xpath ("//div[@class='pull-right']//li[1]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(saveClose).click().build().perform();

    }
   @Test
    public void test3() throws InterruptedException {
        test1();
        Thread.sleep(3000);
        WebElement dropdownDelete = driver.findElement(By.cssSelector(".more-bar-holder > div"));
       JavascriptExecutor jse = (JavascriptExecutor) driver;
       //use executeScript
       jse.executeScript("arguments[0].click();", dropdownDelete);
       Thread.sleep(2000);
       WebElement edit = driver.findElement(By.xpath("//div/ul/li/ul/li[2]/a[@title = 'Edit']"));
       edit.click();
       Thread.sleep(2000);
       WebElement delete = driver.findElement(By.xpath("//div/ul/li/ul/li/a[@title = 'Delete']"));
       delete.click();
   }

   @Test
    public void test4() throws InterruptedException {
        test1();
        Thread.sleep(2000);
        

   }
   @Test
    public void test5() throws InterruptedException {
       WebElement username = driver.findElement(By.id("prependedInput"));
       username.sendKeys("user4");
       WebElement password = driver.findElement(By.id("prependedInput2"));
       password.sendKeys("UserUser123");
       WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
       loginButton.click();

       Thread.sleep(3000);
       WebElement fleetGrid = driver.findElement(By.className("title-level-1"));
       Actions actions = new Actions(driver);
       actions.moveToElement(fleetGrid).perform();
       Thread.sleep(3000);

       WebElement vehicle = driver.findElement(By.xpath("//span[text()='Vehicles']"));
       actions.moveToElement(vehicle).click().perform();

       Thread.sleep(2000);
       WebElement licensePlate = driver.findElement(By.xpath("//table//tbody/tr[2]/td[1]"));
       Thread.sleep(2000);
       licensePlate.click();

       //WebDriverWait wait = new WebDriverWait(driver, 20);
       // WebElement general = driver.findElement(By.linkText("General"));
       //wait.until(ExpectedConditions.visibilityOf(general));

       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[1]/div/a[@title='Add an event to this record']")).click();
       WebElement title = driver.findElement(By.xpath("//input[@name ='oro_calendar_event_form[title]']"));

//       //wait.until(ExpectedConditions.visibilityOf(title));
      title.sendKeys("Ice-cream Party");
      Thread.sleep(2000);
      driver.switchTo().frame(0);
//
//       //clear before sendkeys
      driver.findElement(By.id("tinymce")).clear();
      driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");
       driver.switchTo().defaultContent();
       Thread.sleep(1000);



   }

   }


