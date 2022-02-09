package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {
    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement btnConfirm;

    public OrderSummary() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmationPage clickOnConfirm() {
        Action.click(getDriver(), btnConfirm);
        return new OrderConfirmationPage();
    }
}
