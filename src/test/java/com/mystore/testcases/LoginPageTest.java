package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class LoginPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Sanity", "Smoke"})
    public void loginTest(String uname, String pswd) {
        Log.startTestCase("loginTest");
        indexPage = new IndexPage();

        Log.info("user is going to click on SignIn");
        loginPage = indexPage.clickOnSignIn();

        Log.info("Enter Username and Password");
//        homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
        homePage = loginPage.Login(uname, pswd);
        String actHomePageURL = homePage.getCurrentURL();
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";

        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actHomePageURL, expectedURL);

        Log.info("Login is Success");
        Log.endTestCase("loginTest");

    }

}
