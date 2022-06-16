package com.pages.network;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.genericUtils.BasePage.*;

public class NetworkProfilePage {
    public WebDriver driver;
    String desc;
    @FindBy(xpath = "(//li[@class='cursor-pointer nav-item'])[2]")
    private WebElement network;
    @FindBy(xpath = "//h1[@class='display-3 pc-network-explorer-bg']")
    private WebElement networkPageTitle;
    @FindBy(xpath = "//button[.='Create']")
    private WebElement create;
    @FindBy(xpath = "//small")
    private List<WebElement> options;
    @FindBy(xpath = "//input[@placeholder='Lata']")
    private  WebElement lataName;
    @FindBy(xpath = "//input[@placeholder='LRN']")
    private WebElement LRNName;
    @FindBy(xpath = "//textarea[@placeholder='Description']")
    private WebElement description;
    @FindBy(xpath = "//button[.='Save changes']")
    private WebElement saveChanges;
    @FindBy(xpath = "//div[@class='text-center col']//b[2]")
    private WebElement lastPageNumber;
    @FindBy(xpath = "//i[@class='fas fa-angle-double-right']")
    private WebElement lastPage;
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[4]")
    private List<WebElement> lastDesc;
    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//span[.='Modify']")
    private WebElement modify;
    @FindBy(xpath = "//input[contains(@placeholder,'Provider, code, LRN or Block')]")
    private WebElement searchText;
    @FindBy(xpath = "//button[.='Search']")
    private WebElement search;
    @FindBy(xpath = "//h3")
    private WebElement LRNPopUp;
    @FindBy(xpath = "//h5")
    private WebElement LRNDetails;
    @FindBy(xpath = "//table//tbody/tr//td")
    private List<WebElement> values;
    @FindBy(xpath = "//a[.='Export List']")
    private WebElement exportList;
    @FindBy(xpath = "(//div[contains(@class,'mb-0')])[3]|//h5[contains(@class,'mb-0')]")
    private List<WebElement> SPIDHeader;
    @FindBy(xpath = "//label[contains(@class,'h4 p-0 col-')]")
    private List<WebElement> sectionHeader;
    @FindBy(xpath = "//label[.='Porting Information']/../..//div//div//label")
    private List<WebElement> portingInformationSubSectionHeader;
    @FindBy(xpath = "//label[.='Operations Information']/../..//div//div//label")
    private List<WebElement> operationsInformationSubSectionHeader;
    @FindBy(xpath = "//label[.='Contacts']/../..//div//div//label")
    private List<WebElement> contactsSubSectionHeader;
    @FindBy(xpath = "(//label[.='Porting Information']/../..//div//div//input)|//label[.='Porting Information']/../..//div//div//select//option[1]")
    private List<WebElement> portingInformationValues;
    @FindBy(xpath = "(//label[.='Operations Information']/../..//div//div//input)|(//label[.='Operations Information']/../..//div//div//textarea)")
    private List<WebElement> operationsInformationValues;
    @FindBy(xpath = "(//label[.='Contacts']/../..//div//div//input)")
    private List<WebElement> contactsValues;
    public NetworkProfilePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void navigateToNetwork() throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(10000);
        action.moveToElement(network).clickAndHold(network).pause(1000).click(network).build().perform();
    }
    public void clickOnCreate() throws IOException {
        elementClick(create);
    }
    public void verifyIconsList(){

        for (int i = 0; i < options.size(); i++) {
            if(i==0){
                verifyElement("Network Profile",options.get(i).getText());
            }
            else if(i==1){
                verifyElement("Block",options.get(i).getText());
            }
            else if(i==2){
                verifyElement("NPA-NXX",options.get(i).getText());
            }
            else if(i==3){
                verifyElement("Lrn",options.get(i).getText());
            }
            else if(i==4){
                verifyElement("TPP",options.get(i).getText());
            }
        }
    }
    public void clickOnNetworkProfile() throws IOException {
        elementClick(options.get(0));
    }
    public void enterLRN(String lrn) throws IOException {
        enterValue(LRNName,lrn);
        logger.log(LogStatus.PASS, "Entered LRN is :"+lrn);

    }
    public void enterLATA(String lata) throws IOException {
        enterValue(lataName,lata);
        logger.log(LogStatus.PASS, "Entered LATA is :"+lata);

    }
    public String enterDescription() throws IOException {
        desc="Test"+randomAccountNumberGeneration();
        enterValue(description,desc);
        logger.log(LogStatus.PASS, "Entered Description is :"+desc);
        return desc;

    }
    public void clickOnSaveChanges() throws IOException {
        elementClick(saveChanges);
    }
    public WebElement getNetworkPageTitle(){
        waitForPageLoad();
        return networkPageTitle;
    }
    public void changeToLastPage() throws IOException {
        int i = Integer.parseInt(lastPageNumber.getText());
        if(i>1){
            elementClick(lastPage);
            waitForPageLoad();
        }
    }
    public WebElement getLastDesc(){
        WebElement ele=null;
        for (WebElement element:lastDesc) {
            if(element.getText().equalsIgnoreCase(desc)){
                ele=element;
            }
        }
        return ele ;
    }
    public void clickOnModifyNetwork() throws IOException {
         elementClick( driver.findElement(By.xpath("//td[contains(.,'"+desc+"')]/..//td//li//a//i")));
        if(getElement(modify)){
        elementClick(modify); }
    }
    public void clearDescription() throws IOException {
        elementClear(description);
    }
    public void enterDataInSearchBox(String lrn) throws IOException {
        enterValue(searchText,lrn);
    }
    public void clearDataInSearchBox() throws IOException {
        elementClear(searchText);
    }
    public void clickOnSearch() throws IOException {
        elementClick(search);
    }
    public void printLRNInformation(){
        ArrayList column1 = new ArrayList();
        ArrayList column2 = new ArrayList();
        for(int i=0;i<values.size();i++) {
            if(i%2==0){
            column1.add(values.get(i).getText());}
        }
        for(int i=0;i<values.size();i++) {
            if(i%2!=0){
                column2.add(values.get(i).getText());}
        }
        for (int i = 0; i <values.size()/2; i++) {
            logger.log(LogStatus.PASS, column1.get(i)+" : "+column2.get(i)+"\n");
        }
    }
    public void clickOnExport() throws IOException {
        elementClick(exportList);
    }
    public void verifySPIDHeader(int i){
        waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        if(i==228){
            softAssert.assertEquals(SPIDHeader.get(0).getText(),"Y228/1");
            softAssert.assertEquals(SPIDHeader.get(1).getText(),"SPID Y228");
        }
        else if(i==128){
            softAssert.assertEquals(SPIDHeader.get(0).getText(),"PortControl SPID Y128");
            softAssert.assertEquals(SPIDHeader.get(1).getText(),"SPID Y128");
        }
        softAssert.assertEquals(SPIDHeader.get(2).getText(),"Wireline");
        softAssert.assertEquals(SPIDHeader.get(3).getText(),"United");
    }
    public void printSPIDOrgInformation(){
        for (int i = 0; i < sectionHeader.size(); i++) {
            logger.log(LogStatus.PASS, sectionHeader.get(i).getText()+" : ");
            if(sectionHeader.get(i).getText().equalsIgnoreCase("Porting Information")){
                for (int j = 0; j < portingInformationSubSectionHeader.size(); j++) {
                    logger.log(LogStatus.PASS, portingInformationSubSectionHeader.get(j).getText()+" : "+portingInformationValues.get(j).getAttribute("value"));
                }
            }
            else if(sectionHeader.get(i).getText().equalsIgnoreCase("Operations Information")){
                for (int j = 0; j < operationsInformationSubSectionHeader.size(); j++) {
                    logger.log(LogStatus.PASS, operationsInformationSubSectionHeader.get(j).getText()+" : "+operationsInformationValues.get(j).getAttribute("value"));
                }
            }
            else if(sectionHeader.get(i).getText().equalsIgnoreCase("Contacts")){
                for (int j = 0; j < contactsSubSectionHeader.size(); j++) {
                    logger.log(LogStatus.PASS, contactsSubSectionHeader.get(j).getText()+" : "+contactsValues.get(j).getAttribute("value"));
                }
            }
        }
    }
    public void verifyRespOrgHeader(String org){
        waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        if(org.equals("VZM01")){
            softAssert.assertEquals(SPIDHeader.get(0).getText(),"VERIZON BUSINESS");
            softAssert.assertEquals(SPIDHeader.get(1).getText(),"RespOrg VZM01");
        }
        else if(org.equals("SOE72")){
            softAssert.assertEquals(SPIDHeader.get(0).getText(),"SIGNAL ONE INC.");
            softAssert.assertEquals(SPIDHeader.get(1).getText(),"RespOrg SOE72");
        }

    }

}
