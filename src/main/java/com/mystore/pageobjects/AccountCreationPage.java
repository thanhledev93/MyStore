package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    WebElement txtHeaderPage;

    public AccountCreationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean validateHeaderPage() {
        return Action.isDisplayed(getDriver(), txtHeaderPage);
    }
}
