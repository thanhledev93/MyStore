package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@id='email']")
    WebElement txtEmail;
    
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement txtPassword;
    
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement btnSignIn;
    
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement txtCreateEmail;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement btnCreateNewAccount;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage Login(String uname, String pswd) {
        Action.type(txtEmail, uname);
        Action.type(txtPassword, pswd);
        Action.click(getDriver(), btnSignIn);
        return new HomePage();
    }

    public AddressPage Login1(String uname, String pswd) {
        Action.type(txtEmail, uname);
        Action.type(txtPassword, pswd);
        Action.click(getDriver(), btnSignIn);
        return new AddressPage();
    }

    public AccountCreationPage createNewAccount(String newEmail) {
        Action.type(txtCreateEmail, newEmail);
        Action.click(getDriver(), btnCreateNewAccount);
        return new AccountCreationPage();
    }
}
