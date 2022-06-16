package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTest extends BaseTest {
    @Test(priority = 2)
    public void testSearch() throws InterruptedException, IOException {
        logger = extent.startTest("Search(ProjID/SPID/TN) Test");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToDashboard();
        logger.log(LogStatus.PASS,"Navigate To Dashboard");
        BasePage.pageRefresh();
        dashboardPage.search(prop.getProperty("projectIdStartsWith"));
        String projectId = dashboardPage.getProjectId();
        dashboardPage.clearSearchField();
        dashboardPage.search(projectId);
        logger.log(LogStatus.PASS,"Searched with Project ID :"+projectId);
        dashboardPage.compareAndOpenId(projectId,"ProjectId");
        BasePage.verifyTitle(dashboardPage.getPageTitle());
        BasePage.navigateToBackPage();
//      SPID ID
        dashboardPage.search("Y128");
        String spidId = dashboardPage.getSpidId();
        dashboardPage.clearSearchField();
        dashboardPage.search(spidId);
        logger.log(LogStatus.PASS,"Searched with Spid ID :"+spidId);
        dashboardPage.compareAndOpenId(spidId,"Spid Id");
        BasePage.verifyTitle(dashboardPage.getPageTitle());
        BasePage.navigateToBackPage();

//    TN
        dashboardPage.search("5274206348");
        logger.log(LogStatus.PASS,"Searched with TN :5274206348");
        dashboardPage.compareAndOpenId("5274206348","TN");
        BasePage.verifyTitle(dashboardPage.getPageTitle());
        BasePage.navigateToBackPage();


    }

}
