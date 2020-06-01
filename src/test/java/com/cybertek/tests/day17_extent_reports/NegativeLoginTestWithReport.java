package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPasswordTest(){
        extentLogger = report.createTest("Wrong Password Test");

        loginPage.usernameInput.sendKeys("User1");
        extentLogger.info("Enter Username:User1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/loginN");
        //Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("url"));

        //we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("Wrong Password Test is passed");

    }

    @Test
    public void wrongUsernameTest(){
        extentLogger = report.createTest("Wrong Username Test");

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter Password: UserUser123");


        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

        extentLogger.pass("PASS: Wrong password Test");

    }

}
