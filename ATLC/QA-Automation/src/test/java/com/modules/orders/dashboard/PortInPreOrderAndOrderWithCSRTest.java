package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.pages.orders.dashboard.PortInPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.genericUtils.BasePage.*;

public class PortInPreOrderAndOrderWithCSRTest extends BaseTest {
    @Test(priority = 5)
    public void testPortInPreOrderAndOrderWithCSR() throws IOException, InterruptedException {
        logger = extent.startTest("Test PortIn PreOrderAndOrder With CSR");
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
        portInPage.enterPortingNumbers(generateNewPortNumber());
        logger.log(LogStatus.PASS,"Entered new PortNumber");
        portInPage.typeOfOrder("PreOrder & Order");
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
            portInPage.selectHandledBy();
            portInPage.clickOnCreate();
            dashboardPage.search(projectID);
            logger.log(LogStatus.PASS,"Searched with Project ID :"+projectID);
            verifyElement("CSR Pending",portInPage.getStatus());
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            BasePage.verifyTitle(dashboardPage.getPageTitle());
            portInPage.verifyPortTypeAndStatus("CSR Pending","port-in" );
            portInPage.clickOnActions();
            portInPage.clickOnRequestCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to change to CSR Requested?");
            portInPage.clickOnYesButton();
            portInPage.verifyPortTypeAndStatus("CSR Requested","port-in" );
            portInPage.verifyProjectID(projectID);
            portInPage.downloadAttachments(1);
            waitForPageLoad();
            dashboardPage.search(projectID);
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            portInPage.clickOnActions();
            portInPage.clickOnEscalateCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to change to CSR Escalated?");
            portInPage.clickOnCancelButton();
            portInPage.clickOnActions();
            portInPage.clickOnEscalateCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to change to CSR Escalated?");
            portInPage.clickOnYesButton();
            logger.log(LogStatus.PASS,"Clicked on Yes ");
            portInPage.verifyPortTypeAndStatus("CSR Escalated","port-in" );
            portInPage.clickOnActions();
            portInPage.clickOnApproveCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to approve the CSR and proceed to LSR?");
            portInPage.clickOnCancelButton();
            portInPage.clickOnActions();
            portInPage.clickOnApproveCSR();
            portInPage.verifyConfirmationPopUp("Are you sure you want to approve the CSR and proceed to LSR?");
            portInPage.clickOnYesButton();
            portInPage.verifyPortTypeAndStatus("LSR Pending","port-in" );
            portInPage.clickOnActions();
            portInPage.verifySubmit();
            portInPage.clickOnActions();
            portInPage.clickOnApprove();
            portInPage.clearApproveConfirmationPopUp();
            portInPage.verifyPortTypeAndStatus("Received FOC","port-in" );
            portInPage.downloadAttachments(2);

        }
        else{
            scrollTillElement(portInPage.getErrorMessage());
            takeScreenShortAndFail(portInPage.getErrorMessage());

        }

    }
}
