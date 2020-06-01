package com.cybertek.tests.Homeworks.Homerwork3;

import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1_6 extends TestBase {


    @Test
    public void test1(){
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //calendarEventsPage.createCalendarEvent.click();

        String expectedResult = "Options";
        String actualResult =  calendarEventsPage.options.getText();

        Assert.assertEquals(expectedResult, actualResult, "Verify that options");

    }

    @Test
    public  void test2(){
        test1();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        String expected = "1";
        String actual = calenderEventsPage.page.getAttribute("value");
        Assert.assertEquals(expected, actual, "Verify page number is 1");

    }

    @Test
    public void test3(){
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String expected = driver.findElement(By.cssSelector(".btn-group > button[class='btn dropdown-toggle ']")).getText();
        String actual = "25";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test4(){
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        WebElement AllRows = driver.findElement(By.xpath("//table/tbody[@class='grid-body']"));
        List<WebElement> TotalRowsList = AllRows.findElements(By.tagName("tr"));
        //System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());

        WebElement records = driver.findElement(By.xpath("//label[@class='dib'][3]"));
        //System.out.println(records.getText());
        String textRecords = records.getText();

        String []recordsLine=textRecords.split(" ");
        //System.out.println("Number of records = "+recordsLine[2]);

        Assert.assertEquals(TotalRowsList.size(), Integer.parseInt(recordsLine[2]), "Verify that records equal to number of rows");

    }

    @Test
    public void test5(){
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        WebElement checkbox = driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[2]/input"));
        checkbox.click();

        Assert.assertTrue(checkbox.isSelected(),"checkbox is selected");

    }

    @Test
    public void test6(){
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        BrowserUtils.waitFor(2);

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        WebElement testersMeeting = driver.findElement(By.xpath("//table//tbody/tr[8]/td[2]"));
        testersMeeting.click();
        BrowserUtils.waitFor(3);
        WebElement testersMeet = driver.findElement(By.xpath("//div[text()='Testers meeting']"));
        //String text = generalInfo.getText();
        Assert.assertTrue(testersMeet.isDisplayed(), "Verify that Testers Meeting displayed");
        System.out.println("testers meeting " +testersMeet.getText());


    }

}
