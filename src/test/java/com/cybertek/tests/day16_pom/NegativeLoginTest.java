package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPasswordTest(){

        loginPage.usernameInput.sendKeys("User1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        //Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get("url"));
    }

    @Test
    public void wrongUsernameTest(){

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
}
