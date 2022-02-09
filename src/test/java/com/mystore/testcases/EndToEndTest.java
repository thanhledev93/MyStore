package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCardPage addToCardPage;
    OrderPage orderPage;
    LoginPage loginPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummary orderSummary;
    OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression")
    public void endToEndTest() {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCardPage = searchResultPage.clickOnProduct();
        addToCardPage.enterQuantity("2");
        addToCardPage.selectSize("M");
        addToCardPage.clickOnAddToCard();
        orderPage=addToCardPage.clickOnCheckOut();
        loginPage = orderPage.clickOnCheckOut();
        addressPage = loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage = addressPage.clickOnCheckOut();
        shippingPage.clickOnTerms();
        paymentPage = shippingPage.clickOnCheckOut();
        orderSummary = paymentPage.clickOnPayByWire();
        orderConfirmationPage= orderSummary.clickOnConfirm();
        String actConfirmMess = orderConfirmationPage.validateConfirmMessage();
        String expectedConfirmMess = "Your order on My Store is complete.";

        Assert.assertEquals(actConfirmMess, expectedConfirmMess);


    }
}
