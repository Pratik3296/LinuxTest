package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.pages.orders.dashboard.PortInPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.genericUtils.BasePage.*;

public class OrderPortInCancelTest extends BaseTest {
    @Test(priority = 17)
    public void testOrderPortInCancel() throws IOException, InterruptedException {
        logger = extent.startTest("Test Order page PortIn Cancel");
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
            verifyElement("Pending",portInPage.getStatus());
            dashboardPage.compareAndOpenId(projectID,"ProjectId");
            BasePage.verifyTitle(dashboardPage.getPageTitle());
            portInPage.clickOnActions();
            dashboardPage.clickOnCancel();
            dashboardPage.clearCancelPopUp();
            pageRefresh();
            String status = dashboardPage.verifyStatusAfterCancel();
            portInPage.verifyPortTypeAndStatus("Canceled","port-in" );
            logger.log(LogStatus.PASS,projectID+ " updated with "+status);

            }
        else{
            scrollTillElement(portInPage.getErrorMessage());
            takeScreenShortAndFail(portInPage.getErrorMessage());

        }

    }
}
