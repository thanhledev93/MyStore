package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement btnSignIn;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement imgLogo;
    
    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement txtSearchProduct;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement btnSearchProduct;

    public IndexPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnSignIn() {
        Action.click(getDriver(), btnSignIn);
        return new LoginPage();
    }

    public boolean validateLogo() {
        return Action.isDisplayed(getDriver(), imgLogo);
    }

    public String getMyStoreTitle() {
        return getDriver().getTitle();
    }

    public SearchResultPage searchProduct(String productName) {
        Action.type(txtSearchProduct, productName);
        Action.click(getDriver(), btnSearchProduct);
        return new SearchResultPage();
    }
}
