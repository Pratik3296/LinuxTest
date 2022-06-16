package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.pages.orders.dashboard.PortInPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.genericUtils.BasePage.*;

public class PortInOrderOnlyTest extends BaseTest {
    @Test(priority = 4)
    public void testPortInOrderOnly() throws IOException, InterruptedException {
        logger = extent.startTest("Test PortIn OrderOnly");
        DashboardPage dashboardPage = new DashboardPage(driver);
        PortInPage portInPage=new PortInPage(driver);
        dashboardPage.navigateToDashboard();
        logger.log(LogStatus.PASS,"Navigate To Dashboard");
        BasePage.pageRefresh();
        portInPage.clickOnCreateButton();
        logger.log(LogStatus.PASS,"Clicked on Create");
        portInPage.clickOnPortInButton();
        logger.log(LogStatus.PASS,"Selected PortIn option");
        BasePage.verifyTitle("Port in");
        BasePage.fileUpdate(prop.getProperty("uploadFileName"), Integer.parseInt(prop.getProperty("numberOfPortNumbers")));
        logger.log(LogStatus.PASS,prop.getProperty("uploadFileName")+ " File got Updated with new"+ Integer.parseInt(prop.getProperty("numberOfPortNumbers"))+" PortNumbers ");
        portInPage.uploadFiles(prop.getProperty("uploadFileName"));
        logger.log(LogStatus.INFO,"Verify uploaded numbers");
        portInPage.verifyFileUpload("Excel");
        portInPage.clickOnValidateNumber();
        if(portInPage.errorMessage()!=null){
            verifyElement( portInPage.errorMessage(),"Numbers should only contain 10 digits and optional dashes. Valid examples: 1234567890,111-222-3333,1234567000-8000");
            portInPage.clearTextArea();
            logger.log(LogStatus.PASS,"Text field cleared");}
        else {
            verifyElement("Create" ,portInPage.getCreatePortInHeader().getText());
            logger.log(LogStatus.PASS,"Verified portIn Page Title");
            verifyElement("Enter and Validate Porting Numbers" ,portInPage.getTabHeader().getText());
            verifyElement("Order only" ,portInPage.getSectionHeader().getText());
            portInPage.navigateBackTOOrderPage();
            logger.log(LogStatus.PASS,"Clicked on Back page arrow");
            portInPage.clearPopUp();
            logger.log(LogStatus.PASS,"Discarded alert");
        }
        portInPage.clickOnDownloadTemplate();
        logger.log(LogStatus.PASS,"Template downloaded");
        portInPage.enterPortingNumbers(generateNewPortNumber());
        logger.log(LogStatus.PASS,"Entered new PortNumber");
        portInPage.typeOfOrder("Order only");
        portInPage.clickOnValidateNumber();
        while (portInPage.errorMessage()!=null){portInPage.verifyAndRegeneratePortNumber();}
        if(portInPage.errorMessage()==null){
            verifyElement("Create" ,portInPage.getCreatePortInHeader().getText());
            logger.log(LogStatus.PASS,"Verified portIn Page Title");
            verifyElement("Enter and Validate Porting Numbers" ,portInPage.getTabHeader().getText());
            verifyElement("Order only" ,portInPage.getSectionHeader().getText());
            logger.log(LogStatus.PASS,"PortIn is created for "+portInPage.getPortingTelephoneNumbers().getText());
            portInPage.selectDueDate();
            logger.log(LogStatus.PASS,"PortIn is selected Date: "+portInPage.getDueDate());
            portInPage.selectDueTime();
            String projectID = portInPage.enterProjectID();
            logger.log(LogStatus.PASS,"PortIn ProjectID: "+projectID);
            portInPage.clickOnCreate();
            dashboardPage.search(projectID);
            logger.log(LogStatus.PASS,"Searched with Project ID :"+projectID);
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            BasePage.verifyTitle(dashboardPage.getPageTitle());}
        else{
            scrollTillElement(portInPage.getErrorMessage());
            takeScreenShortAndFail(portInPage.getErrorMessage());

        }

    }
}
