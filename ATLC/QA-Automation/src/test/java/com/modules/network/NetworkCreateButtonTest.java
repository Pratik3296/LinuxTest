package com.modules.network;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.network.NetworkProfilePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class NetworkCreateButtonTest extends BaseTest {

    @Test(priority = 26)
    public void testNetworkCreateButton() throws IOException, InterruptedException {
        logger = extent.startTest("Test Network Create Button");
        NetworkProfilePage networkProfilePage=new NetworkProfilePage(driver);
        logger.log(LogStatus.PASS, "Navigate To Network");
        networkProfilePage.navigateToNetwork();
        BasePage.pageRefresh();
        BasePage.verifyElement(networkProfilePage.getNetworkPageTitle().getText(), "Network");
        logger.log(LogStatus.PASS, "Click on Network create");
        networkProfilePage.clickOnCreate();
        networkProfilePage.verifyIconsList();
    }
}
