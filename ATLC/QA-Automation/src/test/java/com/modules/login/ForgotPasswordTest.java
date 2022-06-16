package com.modules.login;

import com.genericUtils.BaseTest;
import com.pages.login.ForgotPasswordPage;
import com.pages.login.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    @Test(priority = 10)
    public void testForgotPassword() throws InterruptedException {
        logger = extent.startTest("Forgot Password Test");
        ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
        new LoginPage(driver).logOutSteps();
        forgotpasswordpage.getForgotPasswordLink();
        logger.log(LogStatus.PASS,"Clicked on forgot password link");
        forgotpasswordpage.getEmail(prop.getProperty("userName"));
        logger.log(LogStatus.PASS,"Email entered");
        Thread.sleep(10000);
        forgotpasswordpage.getEmailRecovery();
        logger.log(LogStatus.PASS,"Clicked on Email Recovery Link");
        forgotpasswordpage.getBackToLogin();
        logger.log(LogStatus.PASS,"Clicked on Back to Login");
    }
}
