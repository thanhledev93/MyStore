package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {
    @FindBy(xpath = "//input[@id='cgv']")
    WebElement chkTerms;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement btnCheckOut;

    public ShippingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickOnTerms() {
        Action.click(getDriver(), chkTerms);
    }

    public PaymentPage clickOnCheckOut() {
        Action.JSClick(getDriver(), btnCheckOut);
        return new PaymentPage();
    }
}
