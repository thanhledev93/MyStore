package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Sanity")
    public void verifyCreateAccountPageTest() {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount("thanhle.dev.93@gmail.com");
        boolean result = accountCreationPage.validateHeaderPage();
        Assert.assertTrue(result);
    }
}
