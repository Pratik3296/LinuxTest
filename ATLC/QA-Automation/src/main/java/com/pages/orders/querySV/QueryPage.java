package com.pages.orders.querySV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.genericUtils.BasePage.elementClick;
import static com.genericUtils.BasePage.enterValue;
import static com.genericUtils.BaseTest.prop;

public class QueryPage {
    public WebDriver driver;
    @FindBy(xpath = "//a[@data-toggle='collapse']//span[text()='Orders']/..")
    private WebElement orders;
    @FindBy(xpath = "(//span[@class = 'nav-link-text'])[5]")
    private WebElement querySV;
    @FindBy(xpath = "//button[text()='Create']")
    private WebElement create;
    @FindBy(xpath = "//small[text()='Query']")
    private WebElement query;
    @FindBy(xpath = "//h5[@class='modal-title']")
    private WebElement popUp;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement name;
    @FindBy(xpath = "//input[@placeholder='Single or range']")
    private WebElement telephone;
    @FindBy(xpath = "//button[.='Save']")
    private WebElement save;
    public QueryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void navigateToQueryPage() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        Thread.sleep(10000);
        action.moveToElement(orders).clickAndHold(orders).pause(1000).click(orders).click(querySV).build().perform();
        elementClick(querySV) ;
    }
    public void clickOnCreate() throws IOException {
        elementClick(create);
    }
    public void clickOnQuery() throws IOException {
        elementClick(query);
    }
    public void enterQueryName() throws IOException {
        enterValue(name,prop.getProperty("portNumber"));
    }
    public void enterTelephoneNumbers() throws IOException {
        enterValue(telephone,prop.getProperty("portNumber"));
    }
    public void clickOnSave() throws IOException {
        elementClick(save);
    }
}
