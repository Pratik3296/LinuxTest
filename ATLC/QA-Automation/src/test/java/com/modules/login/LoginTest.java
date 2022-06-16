package com.modules.login;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.dashboard.PortInPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.genericUtils.BasePage.loginToApplication;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLogin() throws IOException {
        logger = extent.startTest("Test Login");
        PortInPage portInPage=new PortInPage(driver);
        loginToApplication(prop.getProperty("userName"),prop.getProperty("password"));
        BasePage.verifyTitle("Explore");
        portInPage.changeProfile();
        Thread.sleep(1000);
    }

}
