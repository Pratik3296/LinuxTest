package com.pages.orders.dashboard;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.genericUtils.BasePage.*;
import static com.genericUtils.BaseTest.js;

public class PortOutPage {
    @FindBy(xpath = "//button[text()='Create']")
    private WebElement create;
    @FindBy(xpath = "//small[text()='Port-Out']")
    private WebElement portOut;
    @FindBy(xpath = "//li[text()='Port out']")
    private WebElement  pageHeader;
    @FindBy(xpath = "//textarea[contains(@class,'input-group-merge pc-search-container mb-')]")
    private WebElement portValidateTextArea;
    @FindBy(xpath = "(//a[@class='nav-link pr-0 cursor-pointer'])[1]")
    private WebElement profile;
    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    private WebElement switchToProfile;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchProfile;
    @FindBy(xpath = "//li[contains(@id,'-Y128')]")
    private WebElement selectProfile;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFiles;
    @FindBy(xpath = "//label[@class='form-control-label text-primary']")
    private  WebElement informationMessage;
    @FindBy(xpath = "//select[@class='form-control form-control-sm select2-hidden-accessible']")
    private WebElement serviceProvider;
    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement serviceProviderSearchBox;
    @FindBy(xpath = "//li[@role='option']")
    private List<WebElement> serviceProviderOptions;
    @FindBy(xpath = "//button[.='Generate card']")
    private  WebElement generateCard;
    @FindBy(xpath = "//h5[@class='h3 mb-0']")
    private List<WebElement> portOutPages;
    @FindBy(xpath = "(//div[@class='rdt']//input)[1]")
    private WebElement dueDate;
    @FindBy(xpath = "//tbody//tr//td[2][@class='rdtDay']|//tbody//tr//td[3][@class='rdtDay']|//tbody//tr//td[4][@class='rdtDay']|//tbody//tr//td[5][@class='rdtDay']|//tbody//tr//td[6][@class='rdtDay']")
    private List<WebElement> dates;
    @FindBy(xpath = "//span[text()='›']")
    private WebElement nextMonth;
    @FindBy(xpath = "//input[@class='form-control form-control-sm form-control']")
    private WebElement projectId;
    @FindBy(xpath = "//span[@class='alert-icon']/..//a")
    private List<WebElement> maintenanceWindowErrorMessage;
    @FindBy(xpath = "(//div[@class='rdt']//input)[2]")
    private WebElement dueTime;
    @FindBy(xpath = "//span[@class='rdtBtn']")
    private List<WebElement> arrows;
    @FindBy(xpath = "(//button[@class='btn btn-success'])[2]")
    private WebElement portOutCreate;
    @FindBy(xpath = "//span[@class='h2 font-weight-bold text-white mb-0']")
    private List<WebElement> cardBodyHeaders;
    public PortOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void clickOnCreateButton() throws IOException {
        elementClick(create);
    }


    public void clickOnPortOutButton() throws IOException {
        elementClick(portOut);
    }
    public void changeProfile() throws IOException {
        elementClick(profile);
        elementClick(switchToProfile);
        enterValue(searchProfile,"Y128");
        elementClick(selectProfile);
    }
    public void enterAndValidatePortingNumbers(String portNumber) throws IOException {
        enterValue(portValidateTextArea,portNumber);
    }
    public void uploadFiles(String fileName) {
        js.executeScript("arguments[0].scrollIntoView();", uploadFiles);
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/upload/"+fileName);
        js.executeScript("arguments[0].style.display = 'block';", uploadFiles);
        uploadFiles.sendKeys(file.getAbsolutePath());
    }
    public void selectServiceProvider() throws IOException {
        selectByVisibleText(serviceProvider,"Y228 (Y228/1)");

    }
    public void clickOnGenerateCard() throws IOException {
        elementClick(generateCard);
    }
    public void verifyFileUpload(){
        if(getElement(informationMessage)&&informationMessage.getText().contains("porting number(s) detected.")){
            logger.log(LogStatus.INFO,informationMessage.getText() );
        }
        else {
            logger.log(LogStatus.WARNING,informationMessage.getText() );

        }

    }
    public void verifyPagesTitle(int i, String title){
        if(getElement(portOutPages.get(i))&&portOutPages.get(i).getText().contains(title)){
            logger.log(LogStatus.INFO,portOutPages.get(i).getText() );
        }
        else {
            logger.log(LogStatus.WARNING,title+" not available in UI" );
        }
    }
    public void selectDueDate() throws IOException {
        try { elementClick(dueDate);
            elementClick(nextMonth);
            elementClick(givenList_shouldReturnARandomElement(dates));
            System.out.println("date selected");
        }
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }

        if(maintenanceWindowErrorMessage.size()>0){
            dueDate.clear();
            selectDueDate();
        }
        else {
            selectDueTime();
            waitForPageLoad();
        }

    }
    public void selectDueTime() throws IOException {
        try { elementClick(dueTime);
            elementClick(givenList_shouldReturnARandomElement(arrows));}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
        elementClick(driver.findElement(By.xpath("//label[.='Project ID']")));
    }
    public String getDueDate(){
        return dueDate.getAttribute("value");
    }
    public String enterProjectID() throws IOException {
        String projectNumber = randomName("PID-" + prop.getProperty("portNumber"));
        enterValue(projectId,projectNumber);
        return projectNumber;
    }
    public void clickOnCreate() throws IOException {
        elementClick(portOutCreate);
    }
    public void verifyPortTypeAndStatus(String status){
        waitForPageLoad();
        scrollTillElement(cardBodyHeaders.get(0));
        for (int i = 0; i < cardBodyHeaders.size(); i++) {
            if(cardBodyHeaders.get(i).getText().equalsIgnoreCase("port-out")){
                logger.log(LogStatus.PASS,"Port Type : "+cardBodyHeaders.get(i).getText()+" is Expected");
            }
            else if(cardBodyHeaders.get(i).getText().equalsIgnoreCase(status)){
                logger.log(LogStatus.PASS,"Status: "+cardBodyHeaders.get(i).getText()+" is Expected");

            }
            else {
                logger.log(LogStatus.WARNING,cardBodyHeaders.get(i).getText()+" is not Expected");

            }
        }
    }
}
