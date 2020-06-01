package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderEventsPage extends BasePage {

    public CalenderEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "[class='btn btn-link dropdown-toggle']")
    public WebElement options;

    @FindBy(xpath = "//ul/li[2]/input")
    public WebElement page;


}
