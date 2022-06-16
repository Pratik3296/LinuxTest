package com.pages.orders.dashboard;

import com.genericUtils.BasePage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.genericUtils.BasePage.*;
import static com.genericUtils.BaseTest.js;

public class PortInPage {
    static String date;
    @FindBy(xpath = "//button[text()='Create']")
    private WebElement create;
    @FindBy(xpath = "//small[text()='Port-In']")
    private WebElement portIn;
    @FindBy(xpath = "//li[text()='Port in']")
    private WebElement  pageHeader;
    @FindBy(xpath = "//textarea[contains(@class,'input-group-merge pc-search-container mb-')]")
    private WebElement portValidateTextArea;
    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement orderType;
    @FindBy (linkText = "Download template")
    private WebElement downloadTemplate;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFiles;
    @FindBy(xpath = "//button[text()='Validate numbers']")
    private WebElement validateNumbers;
    @FindBy(xpath = "//span[@class='alert-text ml-1 flex-basis-95']")
    private  WebElement errorMessage;
    @FindBy(xpath = "//span[@class='pc-breadcrumb-item']")
    private  WebElement createPortInHeader;
    @FindBy(xpath = "//span[text()='Enter and Validate Porting Numbers']")
    private WebElement tabHeader;
    @FindBy(xpath = "//ul[@id='account-tabs']//li")
    private WebElement sectionHeader;
    @FindBy(xpath = "(//div[@class='rdt']//input)[1]")
    private WebElement dueDate;
    @FindBy(xpath = "//tbody//tr//td[2][@class='rdtDay']|//tbody//tr//td[3][@class='rdtDay']|//tbody//tr//td[4][@class='rdtDay']|//tbody//tr//td[5][@class='rdtDay']|//tbody//tr//td[6][@class='rdtDay']")
    private List<WebElement> dates;
    @FindBy(xpath = "//span[text()='›']")
    private WebElement nextMonth;
    @FindBy(xpath = "//input[@placeholder='Project ID']")
    private WebElement projectId;
    @FindBy(xpath = "//select[@class='form-control form-control form-control-sm p-1 form-control-sm']")
    private WebElement LRN;
    @FindBy(xpath = "//input[contains(@id,'customCheckport-to-original')]")
    private WebElement portToOriginal;
    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createOrder;
    @FindBy(xpath = "(//a[@class='nav-link pr-0 cursor-pointer'])[1]")
    private WebElement profile;
    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    private WebElement switchToProfile;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchProfile;
    @FindBy(xpath = "//li[contains(@id,'-Y228')]")
    private WebElement selectProfile;
    @FindBy(xpath = "(//span[@class='cursor-pointer'])[2]")
    private WebElement backPageNavigation;
    @FindBy(id = "modal-title-default")
    private WebElement alertHeader;
    @FindBy(xpath = "//span[@class='alert-text ml-1 flex-basis-95']")
    private List<WebElement> alertMessageInorder;
    @FindBy(xpath = "//div[@class='modal-body pb-0']//p")
    private WebElement alertMessage;
    @FindBy(xpath = "//button[.='Discard']")
    private WebElement discard;
    @FindBy(xpath = " //label[.='Porting Telephone Numbers']/..//textarea")
    private WebElement portingTelephoneNumbers;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement createPortIn;
    @FindBy(xpath = "(//div[@class='rdt']//input)[2]")
    private WebElement dueTime;
    @FindBy(xpath = "//span[@class='rdtBtn']")
    private List<WebElement> arrows;
    @FindBy(xpath = "//i[@class='far fa-file-upload']/..//small")
    private WebElement file;
    @FindBy(xpath = "//i[@class='far fa-file-upload']/..//small")
    private WebElement uploadedFileName;
    @FindBy(xpath = "//*[@id='customCheckLabelcsrRequest']")
    private WebElement CSRRequest;
    @FindBy(xpath = "//input[@placeholder='Account Name']")
    private WebElement accountName;
    @FindBy(xpath = "//input[@placeholder='Account Number']")
    private WebElement accountNumber;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[1]")
    private WebElement accountType;
    @FindBy(xpath = "//input[@placeholder='Account PIN/Password']")
    private WebElement accountPINPassword;
    @FindBy(xpath = "//input[@placeholder='Authorized Name']")
    private WebElement authorizedName;
    @FindBy(xpath = "//input[@placeholder='Billing Telephone']")
    private WebElement billingTelephone;
    @FindBy(xpath = "//span[@class='alert-icon']/..//a")
    private List<WebElement> maintenanceWindowErrorMessage;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[2]")
    private WebElement handledBy;
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div[3]/div/div/div/div[2]/table/tbody/tr/td[4]|(//h5/..//span[@class='h2 font-weight-bold text-white mb-0'])[2]")
    private WebElement status;
    @FindBy(xpath = "//span[@class='h2 font-weight-bold text-white mb-0']")
    private List<WebElement> cardBodyHeaders;
    @FindBy(xpath = "//span[@class='inline-text_copy inline-text_copy--active']")
    private WebElement activeProjectID;
    @FindBy(xpath = "//span//i[@class='far fa-file-upload']/..//small")
    private List<WebElement> attachments;
    @FindBy(xpath = "//button[.='Actions']")
    private WebElement actions;
    @FindBy(xpath = "//small[.='Escalate CSR']")
    private WebElement escalateCSR;
    @FindBy(xpath ="//*[@id='modal-title-default']")
    private WebElement confirmationPopUp;
    @FindBy(xpath = "//div[@class='modal-body pb-0']//p")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//*[@class='ml-auto btn btn-danger']")
    private WebElement yesButton;
    @FindBy(xpath = "//*[@class='btn btn-link']")
    private WebElement cancelButton;
    @FindBy(xpath = "//small[.='Approve CSR']")
    private WebElement approveCSR;
    @FindBy(xpath = "//small[.='Submit']")
    private WebElement submit;
    @FindBy(xpath = "//small[.='Approve']")
    private WebElement approve;
    @FindBy(xpath = "//small[contains(.,'Reject')]")
    private WebElement reject;
    @FindBy(xpath = "//label[.='Due date']/..//div//input")
    private WebElement approveDueDate;
    @FindBy(xpath = "//label[.='Due date']/..//span[text()='›']")
    private WebElement approvalNextMonth;
    @FindBy(xpath = "//label[.='Due date']/..//tbody//tr//td[@class='rdtDay']")
    private List<WebElement> approvalDates;
    @FindBy(xpath = "(//div[@role='alert']//div[.='Confirm submitted is not possible with OrderStatus Submitted'])[2]")
    private WebElement alertInformation;
    @FindBy(xpath = "(//div[@class='mb-2 form-group']//select)[2]")
    private WebElement reasonForRejection;
    @FindBy(xpath = "//small[.='Modify CSR']")
    private WebElement modifyCSR;
    @FindBy(xpath = "//*[@class='modal-title']")
    private WebElement modifyCSRPopup;
    @FindBy(xpath = "//button[.='Save changes']")
    private WebElement saveChanges;
    @FindBy(xpath = "//h5[@class='mt-3 mb-0']")
    private List<WebElement> statusCount;
    @FindBy(xpath = "(//p[@class='text-sm mt-1 mb-0'])[1]")
    private WebElement orderUpdateDate;
    @FindBy(xpath = "//small[.='Supplement']")
    private WebElement supplement;
    @FindBy(xpath = "//div[@class='mb-2 flex-fill form-group']//select[@class='form-control form-control-sm']")
    private WebElement submitNewSupplement;
    @FindBy(xpath = "//small[.='Cancel']")
    private WebElement cancelCSR;
    @FindBy(xpath = "//small[.='Archive']")
    private WebElement archive;
    @FindBy(xpath = "//small[.='Submit LSR']")
    private WebElement submitLSR;
    @FindBy(xpath = "//div[@class='dropdown show']//div[@role='menu']//small")
    private List<WebElement> actionIcons;
    @FindBy(xpath = "//small[.='CSR Requested']")
    private WebElement CSRRequested;
    public PortInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void clickOnCreateButton() throws IOException {
        elementClick(create);
    }
    public void changeProfile() throws IOException {
        elementClick(profile);
        elementClick(switchToProfile);
        enterValue(searchProfile,"Y228");
        elementClick(selectProfile);
    }

    public void clickOnPortInButton() throws IOException {
        elementClick(portIn);
    }

    public void enterPortingNumbers(String portNumber) throws IOException {
        enterValue(portValidateTextArea,portNumber);
    }
    public void typeOfOrder(String value ){
        BasePage.selectByVisibleText(orderType,value);
    }
    public void clickOnValidateNumber() throws IOException {
        elementClick(validateNumbers);
        waitForPageLoad();
        if(alertMessageInorder.size()>1){
            elementClick(backPageNavigation);
            clearPopUp();
            clearTextAreaAndEnterNewValue();
        }

    }
    public WebElement getCreatePortInHeader(){
        return createPortInHeader;

    }
    public void navigateBackTOOrderPage() throws IOException {
        elementClick(backPageNavigation);
    }
    public WebElement getTabHeader(){
        return tabHeader;

    }
    public WebElement getSectionHeader(){
        return sectionHeader;

    }
    public void clearTextArea() throws IOException {
        elementClear(portValidateTextArea);
    }
    public void clickOnDownloadTemplate() throws IOException {
        elementClick(downloadTemplate);
    }
    public WebElement getErrorMessage(){
        return  errorMessage;
    }
    public void verifyAndRegeneratePortNumber() throws IOException {
        while (errorMessage.getText().startsWith("TN")||errorMessage.getText().startsWith("Numbers ")){
            clearTextAreaAndEnterNewValue();
            if(driver.findElements(By.xpath("//span[@class='alert-text ml-1 flex-basis-95']")).size()==0){
                break;
            }
        }
    }

    public void clearTextAreaAndEnterNewValue() throws IOException {
        clearTextArea();
        enterPortingNumbers(generateNewPortNumber());
        clickOnValidateNumber();
    }

    public String errorMessage(){
        String result=null;
        try{
            result =errorMessage.getText();
        }
        catch (Exception exception)
        {
        }

        return  result;
    }
    public void uploadFiles(String fileName) {
        js.executeScript("arguments[0].scrollIntoView();", uploadFiles);
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/upload/"+fileName);
        js.executeScript("arguments[0].style.display = 'block';", uploadFiles);
        uploadFiles.sendKeys(file.getAbsolutePath());
    }

    public void clearPopUp() throws IOException {
        try{
        BasePage.verifyElement("Back to step one",alertHeader.getText());
        BasePage.verifyElement("Are you sure you want to go back to step one? Previous data will be discarded.",alertMessage.getText());
        elementClick(discard);}
        catch (Exception e){}
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
        elementClick(projectId);
    }
    public String getDueDate(){
        return dueDate.getAttribute("value");
    }
    public String enterProjectID() throws IOException {
        String projectNumber = randomName("PID-" + getPortingTelephoneNumbers().getText());
        enterValue(projectId,projectNumber);
        return projectNumber;
    }
    public WebElement getPortingTelephoneNumbers(){
        return portingTelephoneNumbers;
    }
    public void clickOnCreate() throws IOException {
        elementClick(createPortIn);
    }
    public void verifyFileUpload(String fileType){
        if(fileType.equalsIgnoreCase("pdf")){
           if( elementIsVisible("//i[@class='far fa-file-upload']/..//small")){
               logger.log(LogStatus.INFO,"Updated file : "+uploadedFileName.getText() );
           }
           else {
               logger.log(LogStatus.WARNING,"File not uploaded");

           }
        }
        else if(fileType.equalsIgnoreCase("Excel")){
            String values = portValidateTextArea.getText();
            String[] portNumbers = values.split(",");
            String temp = "";
            for (String value:portNumbers) {
                temp=temp+value+",";
            }
            int size = portNumbers.length;
            if(size>0){
                logger.log(LogStatus.INFO,"Excel file Uploaded with: "+temp.replace(",", " ") );
            }
            else {
                logger.log(LogStatus.WARNING,"Excel file not Uploaded " );

            }
        }
        else{
            logger.log(LogStatus.INFO,fileType+" not available" );
        }
    }
    public void clickOnCSRRequest() throws IOException {
        js.executeScript("arguments[0].click();", CSRRequest);
    }

    public void enterAccountName() throws IOException {
        String name = randomName("AccountName");
        enterValue(accountName,name);
        logger.log(LogStatus.PASS,"AccountName : "+name);

    }

    public void enterAccountNumber() throws IOException {
        String name =randomAccountNumberGeneration();
        enterValue( accountNumber,name);
        logger.log(LogStatus.PASS,"Account Number : "+name);

    }

    public void selectAccountType() {
        selectByIndex( accountType,1);
    }

    public void enterAccountPINPassword() throws IOException {
        enterValue( accountPINPassword,randomName("Password"));
    }

    public void enterAuthorizedName() throws IOException {
        enterValue( authorizedName,randomName("AuthorizedName"));
    }

    public void enterBillingTelephone() throws IOException {
        String telephone=randomBillingTelephoneNumber();
        enterValue( billingTelephone,telephone);
        logger.log(LogStatus.PASS,"Billing Telephone : "+telephone);
    }
    public void selectHandledBy(){
        selectByVisibleText(handledBy,"ATL Communications");
    }
    public  void getHandledBy(){
        waitForPageLoad();
        Select select=new Select(handledBy);
        if(select.getFirstSelectedOption().getText().equalsIgnoreCase("ATL Communications")){
            logger.log(LogStatus.PASS,"Handler updated : "+select.getFirstSelectedOption().getText());
        }
        else {
            logger.log(LogStatus.WARNING,"Handler updated : "+select.getFirstSelectedOption().getText());

        }
    }
    public String getStatus(){

        return status.getText();
    }
    public void verifyPortTypeAndStatus(String status, String portType){
        waitForPageLoad();
        scrollTillElement(cardBodyHeaders.get(0));
        for (int i = 0; i < cardBodyHeaders.size(); i++) {
            if(cardBodyHeaders.get(i).getText().equalsIgnoreCase(portType)){
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
    public void verifyProjectID(String projectID){
        verifyElement(projectID,activeProjectID.getText());
    }
    public void  downloadAttachments(int i) throws IOException {
        if(i==1){
        if(getElement(attachments.get(0))){
            logger.log(LogStatus.PASS,attachments.get(0).getText()+" is Available for download");

            elementClick(attachments.get(0));
            logger.log(LogStatus.PASS,driver.getCurrentUrl());
            logger.log(LogStatus.PASS,driver.getTitle());
            driver.navigate().back();
        }
        else {
            logger.log(LogStatus.WARNING,"attachment is not Available for download");

        }}
        else {
            for (int j = 0; j < attachments.size(); j++) {
                if(j!=attachments.size()-1){
                 elementClick(attachments.get(j));
                    driver.navigate().back();
                }
                    logger.log(LogStatus.PASS,attachments.get(j).getText()+" is Available for download");
                }
            }
        }
    public void clickOnActions() throws IOException {
        scrollTillElement(actions);
        elementClick(actions);
    }

    public void clickOnEscalateCSR() throws IOException {
        elementClick(escalateCSR) ;
    }
    public void clickOnRequestCSR() throws IOException {
        elementClick(CSRRequested) ;
    }
    public void verifyConfirmationPopUp(String message) {
        if(getElement(confirmationPopUp)){
            logger.log(LogStatus.PASS,"Confirm Popup is Available");
            verifyConfirmationMessage(message);
        }
        else {
            logger.log(LogStatus.WARNING,"Confirm Popup is not Available");

        }
    }

    public void verifyConfirmationMessage(String message) {
        if(getElement( confirmationMessage)){
            verifyElement(message,confirmationMessage.getText());
        }
    }

    public void clickOnYesButton() throws IOException {
        elementClick(yesButton);
        waitForPageLoad();
    }

    public void clickOnCancelButton() throws IOException {
        elementClick(cancelButton);
    }

    public void clickOnApproveCSR() throws IOException {
        elementClick(approveCSR) ;
    }

    public void verifySubmit() throws IOException {
        elementClick( submit);
        if(getElement(confirmationPopUp)){
            logger.log(LogStatus.PASS,"Confirm Popup is Available");
        }
        else {
            logger.log(LogStatus.WARNING,"Confirm Popup is not Available");

        }
        clickOnYesButton();
    }

    public void clickOnApprove() throws IOException {
        elementClick(approve) ;
    }
    public void clearApproveConfirmationPopUp(){
        if(getElement(confirmationPopUp)){
            logger.log(LogStatus.PASS,"Confirm Popup is Available");
            verifyConfirmationMessage("Are you sure you want to approve the PreOrder?");
            try{elementClick(approveDueDate);
                elementClick(approvalNextMonth);
                elementClick(givenList_shouldReturnARandomElement(approvalDates));
                clickOnYesButton();
            }
            catch (Exception exception){
                logger.log(LogStatus.INFO, "Calendar disabled");
            }
        }
        else {
            logger.log(LogStatus.WARNING,"Confirm Popup is not Available");

        }
    }
public void rejectPortIn() throws IOException {
        elementClick(actions);
        elementClick(reject);
    if(getElement(confirmationPopUp)){
        logger.log(LogStatus.PASS,"Confirm Popup is Available");
        verifyConfirmationMessage("Are you sure you want to reject supplement for this order?");
        try{selectByIndex(reasonForRejection,1);
            clickOnYesButton();
        }
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    else {
        logger.log(LogStatus.WARNING,"Confirm Popup is not Available");

    }
}
public void clickOnModifyCSR() throws IOException {
        elementClick(modifyCSR);
}
    public void clearModifyConfirmationPopUp(){
        if(getElement(modifyCSRPopup)){
            logger.log(LogStatus.PASS,"Confirm Popup is Available");
            try{elementClick(approveDueDate);
                elementClick(approvalNextMonth);
                WebElement ele = givenList_shouldReturnARandomElement(approvalDates);
                date=ele.getText();
                elementClick(ele);
                elementClick(saveChanges);
            }
            catch (Exception exception){
                logger.log(LogStatus.INFO, "Calendar disabled");
            }
        }
        else {
            logger.log(LogStatus.WARNING,"Confirm Popup is not Available");

        }
    }
    public void verifyStatusUpdate(){
        waitForPageLoad();
        if(statusCount.size()>=3&&orderUpdateDate.getText().contains(date)){
            logger.log(LogStatus.PASS,orderUpdateDate.getText());
        }
        else {
            logger.log(LogStatus.WARNING,orderUpdateDate.getText()+" not expected");
        }
    }
    public void clickOnSupplement() throws IOException {
        elementClick(supplement);
    }
    public void selectUpdateDueDate(){
        selectByVisibleText(submitNewSupplement,"Update due date");
        try{elementClick(approveDueDate);
            elementClick(approvalNextMonth);
            WebElement ele = givenList_shouldReturnARandomElement(approvalDates);
            date=ele.getText();
            elementClick(ele);
            elementClick(saveChanges);
        }
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    public void clickOnCancelCSR() throws IOException {
        elementClick(cancelCSR);
    }
    public void cancelPopUpClear() throws IOException {
        if(getElement(alertHeader)){
            logger.log(LogStatus.INFO, alertMessage.getText());
            elementClick(yesButton);
        }
        else {
            logger.log(LogStatus.WARNING, "Confirm action not available");

        }
    }
    public void selectUpdateCancel() throws IOException {
        selectByVisibleText(submitNewSupplement,"Cancel complete order");
        elementClick(saveChanges);
    }
    public void verifyArchive() throws IOException {
        clickOnActions();
        if(getElement(archive)){
            logger.log(LogStatus.INFO, archive.getText()+" option Present");
        }
        else {
            logger.log(LogStatus.WARNING, "Archive not Present");
        }
    }
    public void clickOnSubmitLSR() throws IOException {
        elementClick(submitLSR);
    }

    public void verifyActionIconList(){
        if(actionIcons.size()==2) {
            for (int i = 0; i < actionIcons.size(); i++) {
                if (i == 0) {
                    Assert.assertEquals(actionIcons.get(i).getText(), "Cancel");
                }
                else {
                    Assert.assertEquals(actionIcons.get(i).getText(), "Modify CSR");

                }
                logger.log(LogStatus.INFO, "Action has "+actionIcons.get(i).getText()+"\n");

            }
        }
        else {
            for (WebElement element:actionIcons) {
                logger.log(LogStatus.WARNING, "Action has "+element.getText()+"\n");
            }
        }
    }
 public String returnBillingTN(){
     return billingTelephone.getAttribute("value");
 }
}
