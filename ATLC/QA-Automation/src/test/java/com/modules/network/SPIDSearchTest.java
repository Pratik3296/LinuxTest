package com.modules.network;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.network.NetworkProfilePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class SPIDSearchTest extends BaseTest {
    @Test(priority = 29)
    public void testSPIDSearch() throws IOException, InterruptedException {
        logger = extent.startTest("Test SPID Search");
        NetworkProfilePage networkProfilePage=new NetworkProfilePage(driver);
        logger.log(LogStatus.PASS, "Navigate To Network");
        networkProfilePage.navigateToNetwork();
        BasePage.pageRefresh();
        BasePage.verifyElement(networkProfilePage.getNetworkPageTitle().getText(), "Network");
        networkProfilePage.enterDataInSearchBox(prop.getProperty("SPIDSearch1"));
        logger.log(LogStatus.PASS, "Enter SPID: "+prop.getProperty("SPIDSearch1"));
        networkProfilePage.clickOnSearch();
        logger.log(LogStatus.PASS, "click on Search");
        networkProfilePage.verifySPIDHeader(228);
        networkProfilePage.printSPIDOrgInformation();
        networkProfilePage.clearDataInSearchBox();
        networkProfilePage.enterDataInSearchBox(prop.getProperty("SPIDSearch2"));
        logger.log(LogStatus.PASS, "Enter SPID: "+prop.getProperty("SPIDSearch2"));
        networkProfilePage.clickOnSearch();
        logger.log(LogStatus.PASS, "click on Search");
        networkProfilePage.verifySPIDHeader(128);
        networkProfilePage.printSPIDOrgInformation();

    }
}
