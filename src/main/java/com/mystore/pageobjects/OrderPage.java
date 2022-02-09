package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    WebElement unitPrice;
    
    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement btnCheckout;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double getUnitPrice() {
        String unitPrice1 = unitPrice.getText();
        double finalUnitPrice = Double.parseDouble(unitPrice1.replaceAll("[^a-zA-Z0-9]", ""));
        return finalUnitPrice / 100;
    }

    public double getTotalPrice() {
        String totalPrice1 = totalPrice.getText();
        double finalTotalPrice = Double.parseDouble(totalPrice1.replaceAll("[^a-zA-Z0-9]", ""));
        return finalTotalPrice / 100;
    }

    public LoginPage clickOnCheckOut() {
        Action.JSClick(getDriver(), btnCheckout);
        return new LoginPage();
    }

}
