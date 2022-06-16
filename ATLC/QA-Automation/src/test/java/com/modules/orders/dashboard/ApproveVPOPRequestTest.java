package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.pages.orders.dashboard.PortInPage;
import com.pages.orders.dashboard.PortOutPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.genericUtils.BasePage.*;

public class ApproveVPOPRequestTest extends BaseTest {
    @Test(priority = 24)
    public void testApproveVPOPRequest() throws IOException, InterruptedException {
        logger = extent.startTest("Test Approve VPOP Request");
        DashboardPage dashboardPage = new DashboardPage(driver);
        PortOutPage portOutPage = new PortOutPage(driver);
        if(this.getClass().getSimpleName().contains("VPOP")&&!(dashboardPage.returnProfileName().contains("vpopregression@atlc.com"))){
            loginPage.logOutSteps();
            logger.log(LogStatus.INFO,"Relaunching the Application as a Free User");
            loginToApplication(prop.getProperty("freeUserName"),prop.getProperty("freeUserPassword"));
        }
        PortInPage portInPage=new PortInPage(driver);
        dashboardPage.navigateToDashboardAsAFreeUser();
        BasePage.pageRefresh();
        portInPage.clickOnCreateButton();
        logger.log(LogStatus.PASS,"Clicked on Create");
        portInPage.clickOnPortInButton();
        logger.log(LogStatus.PASS,"Selected PortIn option");
        BasePage.verifyTitle("Port in");
        portInPage.enterPortingNumbers(generateNewPortNumber());
        logger.log(LogStatus.PASS,"Entered new PortNumber");
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
            portInPage.uploadFiles(prop.getProperty("pdfName"));
            portInPage.verifyFileUpload("pdf");
            portInPage.clickOnCSRRequest();
            portInPage.enterAccountName();
            portInPage.enterAccountNumber();
            portInPage.selectAccountType();
            portInPage.enterAccountPINPassword();
            portInPage.enterAuthorizedName();
            portInPage.enterBillingTelephone();
            portInPage.clickOnCreate();
            dashboardPage.search(projectID);
            logger.log(LogStatus.PASS,"Searched with Project ID :"+projectID);
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            BasePage.verifyTitle(dashboardPage.getPageTitle());
            verifyElement("CSR Requested",portInPage.getStatus());
            portInPage.verifyPortTypeAndStatus("CSR Requested","port-in" );
            portInPage.downloadAttachments(1);
            waitForPageLoad();
            dashboardPage.search(projectID);
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            portInPage.clickOnActions();
            portInPage.verifyActionIconList();
            loginPage.logOutSteps();
            loginToApplication(prop.getProperty("userName"),prop.getProperty("password"));
            BasePage.verifyTitle("Explore");
            dashboardPage.navigateToDashboard();
            dashboardPage.search(prop.getProperty("portNumber"));
            dashboardPage.openPortOutId(projectID);
            portOutPage.verifyPortTypeAndStatus("CSR Requested");
            portInPage.clickOnActions();
            portInPage.clickOnApproveCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to approve the CSR and proceed to LSR?");
            portInPage.clickOnYesButton();
            portInPage.verifyPortTypeAndStatus("LSR Pending","port-in" );


        }
        else{
            scrollTillElement(portInPage.getErrorMessage());
            takeScreenShortAndFail(portInPage.getErrorMessage());

        }

    }
}
