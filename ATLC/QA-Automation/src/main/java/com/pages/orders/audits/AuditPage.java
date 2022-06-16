package com.pages.orders.audits;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.genericUtils.BasePage.*;
import static com.genericUtils.BaseTest.prop;

public class AuditPage {
    public WebDriver driver;
    @FindBy(xpath = "//a[@data-toggle='collapse']//span[text()='Orders']/..")
    private WebElement orders;
    @FindBy(xpath = "(//span[@class = 'nav-link-text'])[6]")
    private WebElement mouseHoverOnAudits;
    @FindBy(xpath = "//span[text()='Audits']")
    private WebElement audits;
    @FindBy(xpath = "//h1[@class='display-3 text-blue']")
    private WebElement auditsPageTitle;
    @FindBy(xpath = "//button[.='Create']")
    private WebElement create;
    @FindBy(xpath = "//input[@placeholder='Search for audits']")
    private WebElement search;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchSubmit;
    @FindBy(xpath = "//small[.='Audit']")
    private WebElement audit;
    @FindBy(xpath = "//h5[@class='modal-title']")
    private WebElement popUpTitle;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement name;
    @FindBy(xpath = "//input[@placeholder='Single or range']")
    private WebElement telephone;
    @FindBy(xpath = "//button[.='Save']")
    private WebElement save;
    @FindBy(xpath = "//a[@class='text-underline']/../..//td")
    private List<WebElement> cells;
    @FindBy(xpath = "//a[@class='text-underline']/../..//td//button")
    private WebElement spid;
    @FindBy(xpath = "//span[@class='mb-0 text-sm font-weight-bold']")
    private WebElement profile;
    @FindBy(xpath = "//span[@class='h2 font-weight-bold text-white mb-0']")
    private WebElement auditPageStatus;
    @FindBy(xpath = "//tbody[@role='rowgroup']//tr//td")
    private List<WebElement> columns;
    @FindBy(xpath = "(//table//thead//tr//th//div//div)[position() mod 2=1]")
    private List<WebElement> columnsHeader;
    @FindBy(xpath = "//a[@class='text-underline']")
    private WebElement openAudit;
    public AuditPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void navigateToAudits() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        Thread.sleep(10000);
        action.moveToElement(orders).clickAndHold(orders).pause(1000).click(orders).click(mouseHoverOnAudits).build().perform();
        elementClick(audits) ;
    }
    public void clickOnCreate() throws IOException {
        elementClick(create);
    }
    public void clickOnAudit() throws IOException {
        elementClick(audit);
    }
    public void enterAuditName() throws IOException {
        enterValue(name,prop.getProperty("portNumber"));
    }
    public void enterTelephoneNumbers() throws IOException {
        enterValue(telephone,prop.getProperty("portNumber"));
    }
    public void clickOnSave() throws IOException {
        elementClick(save);
    }
    public WebElement getAuditsPageTitle(){
        return auditsPageTitle;
    }
    public WebElement getPopUpTitle(){
        return popUpTitle;
    }
    public void searchAudit(String auditName) throws IOException {
        enterValue(search,auditName);
    }
    public void clickOnSearch() throws IOException {
        elementClick(searchSubmit);
    }
    public void openAudit() throws IOException {
        elementClick(openAudit);
    }
    public void verifyResult(){
        for (int i = 0; i < cells.size(); i++) {
            if(i==0){
                verifyElement(prop.getProperty("portNumber"),cells.get(i).getText());
            }
            else if(i==1){
                if(cells.get(i).getText().contains(prop.getProperty("portNumber"))){
                    logger.log(LogStatus.PASS,"Telephone: "+prop.getProperty("portNumber")+" is expected");

                }
                else {
                    logger.log(LogStatus.WARNING,"Telephone: "+prop.getProperty("portNumber")+" is not expected");

                }
            }
            else if(i==3){
                informationPrint(prop.getProperty("portNumber")+ " Status is "+ cells.get(i).getText());
            }
        }

    }
    public void printAuditDetails(){
        informationPrint("Audit page Status is" +auditPageStatus.getText());
        waitForPageLoad();
        for (int i = 0; i < columns.size()-1; i++) {
                informationPrint(columnsHeader.get(i).getText()+" : "+ columns.get(i).getText()+"\n ");
        }
    }
}
