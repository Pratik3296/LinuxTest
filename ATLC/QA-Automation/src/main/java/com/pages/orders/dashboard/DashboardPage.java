package com.pages.orders.dashboard;

import com.genericUtils.BasePage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static com.genericUtils.BasePage.*;

public class DashboardPage  {
    public WebDriver driver;
    String oldDueDate;
    String oldStatus;
    @FindBy(xpath = "//span[contains(.,'PID-')]")
    private List<WebElement> projectIdList;
    @FindBy(xpath = "//tr//span[contains(.,'Y')]")
    private List<WebElement> spidIdList;
    @FindBy(xpath = "//tr//td//span[@class='pc-text-link']")
    private List<WebElement> idList;
    @FindBy(xpath = "//input[@placeholder='Search orders by project id or phone number']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;
    @FindBy(xpath = "//a[@data-toggle='collapse']//span[text()='Orders']/..")
    private WebElement orders;
    @FindBy(xpath = "(//span[@class = 'nav-link-text'])[1]")
    private WebElement mouseHoverOnDashboard;
    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboard;
    @FindBy(xpath = "(//a[.='Orders'])[2]")
    private WebElement pageTitle;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[1]")
    private WebElement typeDropDown;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[1]")
    private WebElement dueStartDate;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[2]")
    private WebElement dueEndDate;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[3]")
    private WebElement nextWorkStartDate;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[4]")
    private WebElement nextWorkEndDate;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[2]")
    private WebElement statusDropDown;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[3]")
    private WebElement newSpidDropDown;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[4]")
    private WebElement oldSpidDropDown;
    @FindBy(xpath = "(//select[@class='form-control form-control-sm'])[5]")
    private WebElement workedByDropDown;
    @FindBy(xpath = "//i[@class='fas fa-sync-alt cursor-pointer mx-2']")
    private WebElement refresh;
    @FindBy(xpath = "(//div[@class='rdtPicker'])[1]//tbody//tr//td[@class='rdtDay']")
    private List<WebElement> dueDateCalendarStartDates;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[2]/..//div//table//tbody//tr//td[@class='rdtDay']")
    private List<WebElement> dueDateCalendarEndDates;
    @FindBy(xpath = "(//th[@class='rdtNext'])[1]")
    private WebElement nextMonthSelect;
    @FindBy(xpath = "(//tr//th[@class='rdtPrev']//span[.='‹'])[2]")
    private WebElement previousMonthSelect;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[3]/..//div//tbody//tr//td[@class='rdtDay']")
    private List<WebElement> nextWorkCalendarStarDates;
    @FindBy(xpath = "(//input[@class='form-control form-control-sm bg-white'])[4]/..//div//tbody//tr//td[@class='rdtDay']")
    private List<WebElement> nextWorkCalendarEndDates;
    @FindBy(xpath = "(//tr//th[@class='rdtPrev']//span[.='‹'])[4]")
    private WebElement nextWorkPreviousButton;
    @FindBy(xpath = "(//th[@class='rdtNext'])[4]")
    private WebElement nextWorkNextButton;
    @FindBy(xpath = "//tr[@role='row']//td[@class='p-3 max-width-200']")
    private WebElement dueDate;
    @FindBy(xpath = "(//i[@title='Modify'])[1]")
    private WebElement modify;
    @FindBy(xpath = "(//div[@class='rdt']//input)[5]")
    private WebElement dueDateChange;
    @FindBy(xpath = "(//th[@class='rdtNext'])[5]")
    private WebElement dueDateChangeToNextMonth;
    @FindBy(xpath = "//label[.='Due date']/..//div[@class='rdtDays']//tbody[1]//tr//td[@class='rdtDay']")
    private List<WebElement>  dueDateDates;
    @FindBy(xpath = "//button[.='Save changes']")
    private WebElement saveChanges;
    @FindBy(xpath = "(//i[@title='Cancel'])[1]")
    private WebElement cancel;
    @FindBy(xpath ="//*[@id='modal-title-default']")
    private WebElement confirmationPopUp;
    @FindBy(xpath = "//div[@class='modal-body pb-0']//p")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//*[@class='ml-auto btn btn-danger']")
    private WebElement yesButton;
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div[3]/div/div/div/div[2]/table/tbody/tr[1]/td[4]|//*[@id='root']/div[2]/div/div[2]/div[2]/div[1]/div/div/div[3]/table/tbody/tr/td[4]")
    private WebElement status;
    @FindBy(xpath = "//*[@id='root']/div[2]/div/div[2]/div[2]/div[1]/div/div/div[3]/table/tbody/tr/td[3]")
    private WebElement dueDateInDashBoard;
    @FindBy(xpath = "(//label[.='Due date']/..//div)[1]")
    private WebElement modifyDueDte;
    @FindBy(xpath = "(//span[.='›'])[2]")
    private WebElement modifyNextMonth;
    @FindBy(xpath = "//span[@class='mb-0 text-sm font-weight-bold']")
    private WebElement profileName;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public String getProjectId(){
        return projectIdList.get(0).getText();
    }
    public String getSpidId(){
        return spidIdList.get(0).getText();
    }
    public void navigateToDashboard() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        Thread.sleep(10000);
        action.moveToElement(orders).clickAndHold(orders).pause(1000).click(orders).click(mouseHoverOnDashboard).build().perform();
        elementClick(dashboard) ;
    }
    public void navigateToDashboardAsAFreeUser() throws InterruptedException, IOException {
        BasePage.waitForPageLoad();
        Actions action = new Actions(driver);
        action.moveToElement(orders).clickAndHold(orders).pause(1000).click(orders).click(mouseHoverOnDashboard).build().perform();
        Thread.sleep(10000);
        js.executeScript("arguments[0].click();", orders);
        elementClick(dashboard) ;
    }
    public String getPageTitle(){
        return pageTitle.getText();
    }
    public void search(String id) throws IOException {
        enterValue(searchField,id);
        submit.submit();
    }
    public void compareAndOpenId(String id,String searchFor){
        if(searchFor.equalsIgnoreCase("ProjectId")) {
            for (WebElement element : projectIdList) {
                if (element.getText().equalsIgnoreCase(id)) {
                    element.click();
                    break;
                }
            }
        }
        else if (searchFor.equalsIgnoreCase("Spid Id")) {
            for (WebElement element : spidIdList) {
                if (element.getText().equalsIgnoreCase(id)) {
                    element.click();
                    break;
                }
            }
        }
        else {
            idList.get(0).click();
        }
    }

    public String getTypeDropDown() {
        Select select=new Select(typeDropDown);
        return select.getFirstSelectedOption().getText();}

    public String getDueStartDate() {
        return dueStartDate.getAttribute("value");
    }

    public String getDueEndDate() {
        return dueEndDate.getAttribute("value");
    }

    public String getNextWorkStartDate() {
        return nextWorkStartDate.getAttribute("value");
    }

    public String getNextWorkEndDate() {
        return nextWorkEndDate.getAttribute("value");
    }

    public String getStatusDropDown() {
        Select select=new Select(statusDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public String getNewSpidDropDown() {
        Select select=new Select(newSpidDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public String getOldSpidDropDown() {
        Select select=new Select(oldSpidDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public String getWorkedByDropDown() {
        Select select=new Select(workedByDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public void filterWithType(int i){
        BasePage.selectByIndex(typeDropDown,i);

    }

    public void filterWithStatus(int i){
        BasePage.selectByIndex(statusDropDown,i);
    }
    public void filterWithNewSpid(int i){
        BasePage.selectByIndex(newSpidDropDown,i);
    }
    public void filterWithOldSpid(int i){
        BasePage.selectByIndex(oldSpidDropDown,i);
    }
    public void filterWithWorkedBy(int i){
        BasePage.selectByIndex(workedByDropDown,i);
    }

    public void filterWithDueStartDate() {
        try { elementClick(dueStartDate);
            elementClick(nextMonthSelect);
            elementClick(givenList_shouldReturnARandomElement(dueDateCalendarStartDates));}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    public void filterWithDueEndDate() {
        try{ elementClick(dueEndDate);
            elementClick(previousMonthSelect);
            elementClick(givenList_shouldReturnARandomElement(dueDateCalendarEndDates));}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    public void filterWithNextWorkStartDate() throws IOException {
        waitForPageLoad();
        try {elementClick(nextWorkStartDate);
            elementClick(givenList_shouldReturnARandomElement(nextWorkCalendarStarDates));}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    public void filterWithNextWorkEndDate() throws IOException {
        waitForPageLoad();
        try{elementClick(nextWorkEndDate);
            elementClick(givenList_shouldReturnARandomElement(nextWorkCalendarEndDates));}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
    }
    public void filterRefresh() throws IOException {
        elementClick(refresh);
        waitForPageLoad();
    }

    public void clearSearchField() throws IOException {
        elementClear(searchField);

    }
    public void clickOnModify() throws IOException {
        oldDueDate=getDueDate().getText();
        elementClick(modify);

    }
    public void clickOnModifyInDashboard() throws IOException {
        oldDueDate=getDueDateInDashBoard().getText();
        elementClick(modify);

    }
    public void updateDueDate() throws IOException {

        try{   elementClick(dueDateChange);
            elementClick(dueDateChangeToNextMonth);
            waitForPageLoad();
            elementClick(dueDateChangeToNextMonth);
            waitForPageLoad();
            WebElement element = givenList_shouldReturnARandomElement(dueDateDates);
            elementClick(element);

        }
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
        elementClick(saveChanges);

    }
    public WebElement getDueDate(){
        return dueDate;
    }
    public String verifyUpdate(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(oldDueDate,getDueDate().getText());
      return getDueDate().getText();
    }
    public void clickOnCancel() throws IOException {
        waitForPageLoad();
        oldStatus=getStatus().getText();
        logger.log(LogStatus.INFO, "Before Cancel Status is "+  oldStatus);
        elementClick(cancel);
    }
    public void clearCancelPopUp() throws IOException {
        verifyElement("Confirm action",confirmationPopUp.getText());
        verifyElement("Are you sure you want to cancel this order?",confirmationMessage.getText());
        elementClick(yesButton);
    }
    public WebElement getStatus(){
        return status;
    }
    public String verifyStatusAfterCancel(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(oldStatus,getStatus().getText());
        return getStatus().getText();
    }
    public WebElement getDueDateInDashBoard(){
        return  dueDateInDashBoard;
    }
    public void updateDueDateInDashboard() throws IOException {

        try{   elementClick(modifyDueDte);
            elementClick(modifyNextMonth);
            waitForPageLoad();
            elementClick(modifyNextMonth);
            waitForPageLoad();
            WebElement element = givenList_shouldReturnARandomElement(dueDateDates);
            elementClick(element);

        }
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Calendar disabled");
        }
        elementClick(saveChanges);

    }
    public String verifyUpdateDueDateInDashboard(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(oldDueDate,getDueDateInDashBoard().getText());
        return getStatus().getText();
    }
    public String returnProfileName(){
        return profileName.getText();
    }
    public String openPortOutId(String projectId) throws IOException {
        WebElement element = driver.findElement(By.xpath("(//span[contains(.,'" + projectId + "')]/../..//td[.='CSR Requested']/../..//preceding-sibling::td[.='port-out']/..//td)[1]"));
        String portOutId = element.getText();
        elementClick(element);
        return portOutId;}
}
