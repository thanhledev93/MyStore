package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    @FindBy(xpath="//div[@class='product-image-container']")
    WebElement imgProductResult;

    @FindBy(xpath="//span[normalize-space()='More']")
    WebElement btnMore;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable() {
        return Action.isDisplayed(getDriver(), imgProductResult);
    }

    public AddToCardPage clickOnProduct() {
        Action.mouseOverElement(getDriver(), imgProductResult);
        Action.click(getDriver(), btnMore);
        return new AddToCardPage();
    }
}
