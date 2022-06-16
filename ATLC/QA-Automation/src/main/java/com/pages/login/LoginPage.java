package com.pages.login;

import com.genericUtils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.genericUtils.BasePage.elementClick;
import static com.genericUtils.BasePage.enterValue;
import static com.genericUtils.BaseTest.builder;
import static com.genericUtils.BaseTest.js;

public class LoginPage {
    @FindBy(xpath = "//input[@placeholder = 'Email']")
    private WebElement userName;
    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submit;
    @FindBy(xpath = "//i[@class='ml-2 fa fa-user fa-lg']")
    private WebElement profileIcon;
    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement logout;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void setUserName(String email) throws IOException {
        enterValue(userName,email);
    }
    public void setPassword(String passwordText) throws IOException {
        enterValue(password,passwordText);
    }
    public void clickOnSubmit() throws IOException {
        elementClick(submit);
    }
    public void clickOnProfileIcon()  {

            builder.moveToElement(profileIcon).click(profileIcon).build().perform();

    }
    public void clickOnLogout() {
        builder.pause(5000).build().perform();
         js.executeScript("arguments[0].click();", logout);
    }
    public void logOutSteps(){
        try{
            clickOnProfileIcon();
            clickOnLogout();
        }
        catch (Exception exception){
            BasePage.informationPrint("Already logged out");
        }

    }
}