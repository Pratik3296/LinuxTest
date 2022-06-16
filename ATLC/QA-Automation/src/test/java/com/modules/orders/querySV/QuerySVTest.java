package com.modules.orders.querySV;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.querySV.QueryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class QuerySVTest extends BaseTest {
    @Test(priority = 9)
    public void testQuerySV() throws IOException, InterruptedException {
        logger = extent.startTest("Test QuerySV");
        QueryPage queryPage = new QueryPage(driver);
        queryPage.navigateToQueryPage();
        logger.log(LogStatus.PASS,"Navigate To Query");
        BasePage.pageRefresh();
        queryPage.clickOnCreate();
        logger.log(LogStatus.PASS,"Click on Query create");
        queryPage.clickOnQuery();
        logger.log(LogStatus.PASS,"Click on Query");
        queryPage.enterQueryName();
        logger.log(LogStatus.PASS,"Enter Query name: "+prop.getProperty("portNumber"));
        queryPage.enterTelephoneNumbers();
        logger.log(LogStatus.PASS,"Enter Telephone: "+prop.getProperty("portNumber"));
        queryPage.clickOnSave();
    }
}
