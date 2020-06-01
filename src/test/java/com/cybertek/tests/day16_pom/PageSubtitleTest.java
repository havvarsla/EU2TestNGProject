package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    /**
     * Test case
     * Open browser
     * Login as a driver
     * Verify that page subtitle is Quick Launchedpad
     * Go to activities
     * Verify that
     */

    @Test
    public void test1(){
       LoginPage loginPage = new LoginPage();

       loginPage.loginAsDriver();
       BrowserUtils.waitFor(5);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitles");

        dashboardPage.navigateToModule("Activities", "Calender Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calenderEventsPage.getPageSubTitle(), "Calender Eventss", "cverify subtitles");


    }
}
