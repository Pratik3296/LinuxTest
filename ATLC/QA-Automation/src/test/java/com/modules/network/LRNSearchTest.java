package com.modules.network;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.network.NetworkProfilePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class LRNSearchTest extends BaseTest {
    @Test(priority = 31)
    public void testLRNSearch() throws IOException, InterruptedException {
        logger = extent.startTest("Test LRN Search");
        NetworkProfilePage networkProfilePage=new NetworkProfilePage(driver);
        logger.log(LogStatus.PASS, "Navigate To Network");
        networkProfilePage.navigateToNetwork();
        BasePage.pageRefresh();
        BasePage.verifyElement(networkProfilePage.getNetworkPageTitle().getText(), "Network");
        networkProfilePage.enterDataInSearchBox(prop.getProperty("LRN"));
        logger.log(LogStatus.PASS, "Enter LRN: "+prop.getProperty("LRN"));
        networkProfilePage.clickOnSearch();
        logger.log(LogStatus.PASS, "click on Search");
        networkProfilePage.printLRNInformation();
        networkProfilePage.clickOnExport();
        logger.log(LogStatus.PASS, "click on Export");
    }
}
