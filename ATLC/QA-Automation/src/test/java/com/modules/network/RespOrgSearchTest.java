package com.modules.network;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.network.NetworkProfilePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class RespOrgSearchTest extends BaseTest {
    @Test(priority = 30)
    public void testRespOrgSearch() throws IOException, InterruptedException {
        logger = extent.startTest("Test RespOrg Search");
        NetworkProfilePage networkProfilePage=new NetworkProfilePage(driver);
        logger.log(LogStatus.PASS, "Navigate To Network");
        networkProfilePage.navigateToNetwork();
        BasePage.pageRefresh();
        BasePage.verifyElement(networkProfilePage.getNetworkPageTitle().getText(), "Network");
        networkProfilePage.enterDataInSearchBox(prop.getProperty("RespOrgSearch1"));
        logger.log(LogStatus.PASS, "Enter RespOrgSearch: "+prop.getProperty("RespOrgSearch1"));
        networkProfilePage.clickOnSearch();
        logger.log(LogStatus.PASS, "click on Search");
        networkProfilePage.verifyRespOrgHeader("VZM01");
        networkProfilePage.printSPIDOrgInformation();
        networkProfilePage.clearDataInSearchBox();
        networkProfilePage.enterDataInSearchBox(prop.getProperty("RespOrgSearch2"));
        logger.log(LogStatus.PASS, "Enter RespOrgSearch: "+prop.getProperty("RespOrgSearch2"));
        networkProfilePage.clickOnSearch();
        logger.log(LogStatus.PASS, "click on Search");
        networkProfilePage.verifyRespOrgHeader("SOE72");
        networkProfilePage.printSPIDOrgInformation();
    }
}
