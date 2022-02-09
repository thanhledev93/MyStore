package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCardPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCardPage addToCardPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = {"Regression", "Sanity"})
    public void addToCardTest() {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCardPage = searchResultPage.clickOnProduct();
        addToCardPage.enterQuantity("2");
        addToCardPage.selectSize("M");
        addToCardPage.clickOnAddToCard();
        boolean result = addToCardPage.validateAddToCard();
        Assert.assertTrue(result);

    }
}
