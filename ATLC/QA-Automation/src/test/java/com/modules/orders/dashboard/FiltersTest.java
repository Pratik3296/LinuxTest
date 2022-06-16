package com.modules.orders.dashboard;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.DashboardPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class FiltersTest extends BaseTest {
    @Test(priority = 3)
    public void testFilters() throws IOException, InterruptedException {
        logger = extent.startTest("Test Filters");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToDashboard();
        logger.log(LogStatus.PASS,"Navigate To Dashboard");
        BasePage.pageRefresh();
        commonFilters(dashboardPage,1,3,2,1,1);
        logger.log(LogStatus.PASS,"Filter set-1 working as expected");
        commonFilters(dashboardPage,3,4,1,1,2);
        logger.log(LogStatus.PASS,"Filter set-2 working as expected");

    }
    public void commonFilters(DashboardPage dashboardPage,int filterWithType, int filterWithStatus,int filterWithNewSpid, int filterWithOldSpid,int filterWithWorkedBy) throws IOException {
        dashboardPage.filterWithType(filterWithType);
        BasePage.waitForPageLoad();
        logger.log(LogStatus.PASS,"Type Filter is selected : "+dashboardPage.getTypeDropDown()+" and working as expected");
        dashboardPage.filterWithDueStartDate();
        logger.log(LogStatus.PASS,"Due Start Date Filter is selected : "+dashboardPage.getDueStartDate()+" and  working as expected");
        dashboardPage.filterWithDueEndDate();
        logger.log(LogStatus.PASS,"Due End Date Filter is selected : "+dashboardPage.getDueEndDate()+" and  working as expected");
        dashboardPage.filterWithStatus(filterWithStatus);
        logger.log(LogStatus.PASS,"Status Filter is selected : "+dashboardPage.getStatusDropDown()+" and working as expected");
        dashboardPage.filterWithNewSpid(filterWithNewSpid);
        logger.log(LogStatus.PASS,"New Spid Filter is selected : "+dashboardPage.getNewSpidDropDown()+" and working as expected");
        dashboardPage.filterWithOldSpid(filterWithOldSpid);
        logger.log(LogStatus.PASS,"Old Spid Filter is selected : "+dashboardPage.getOldSpidDropDown()+" and working as expected");
        dashboardPage.filterRefresh();
        dashboardPage.filterWithNextWorkStartDate();
        logger.log(LogStatus.PASS,"Next Work Start Date Filter is selected : "+dashboardPage.getNextWorkStartDate()+" and working as expected");
        dashboardPage.filterWithNextWorkEndDate();
        logger.log(LogStatus.PASS,"Next Work End Date Filter is selected : "+dashboardPage.getNextWorkEndDate()+" and  working as expected");
        dashboardPage.filterWithWorkedBy(filterWithWorkedBy);
        logger.log(LogStatus.PASS,"Worked By Filter is selected : "+dashboardPage.getWorkedByDropDown()+" and  working as expected");
        dashboardPage.filterRefresh();
        logger.log(LogStatus.PASS,"Refresh is  working as expected");
    }
}
