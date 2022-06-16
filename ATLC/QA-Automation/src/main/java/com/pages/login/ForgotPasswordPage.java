package com.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    @FindBy(xpath = "//a[@class = 'text-light text-xs']")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@placeholder = 'Email']")
    private WebElement email;
    @FindBy(xpath = "//button[@class='mt-4 btn btn-primary']")
    private WebElement emailRecovery;
    @FindBy(xpath = "//a[@class = 'text-light']")
    private WebElement backToLogin;
    public ForgotPasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void getForgotPasswordLink() {
         forgotPasswordLink.click();
    }

    public void getEmail(String UserName) {
        email.sendKeys(UserName);
    }

    public void getEmailRecovery() {
         emailRecovery.click();
    }

    public void getBackToLogin() {
         backToLogin.click();
    }
}
