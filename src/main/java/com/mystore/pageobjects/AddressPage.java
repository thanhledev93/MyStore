package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {
    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement btnCheckOut;

    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShippingPage clickOnCheckOut() {
        Action.JSClick(getDriver(), btnCheckOut);
        return new ShippingPage();
    }
}
