package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement payByBankWire;
    
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheck;

    public PaymentPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderSummary clickOnPayByWire() {
        Action.click(getDriver(), payByBankWire);
        return new OrderSummary();
    }

    public void clickOnPayByCheck() {
        Action.click(getDriver(), payByCheck);
    }
}
