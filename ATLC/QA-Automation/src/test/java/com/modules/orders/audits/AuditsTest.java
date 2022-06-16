package com.modules.orders.audits;

import com.genericUtils.BasePage;
import com.genericUtils.BaseTest;
import com.pages.orders.audits.AuditPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuditsTest extends BaseTest {
    @Test(priority = 25)
    public void testAudits() throws IOException, InterruptedException {
        logger = extent.startTest("Test Audits");
        AuditPage auditPage = new AuditPage(driver);
        auditPage.navigateToAudits();
        logger.log(LogStatus.PASS, "Navigate To Audits");
        BasePage.pageRefresh();
        BasePage.verifyElement(auditPage.getAuditsPageTitle().getText(), "Audits");
        auditPage.clickOnCreate();
        logger.log(LogStatus.PASS, "Click on Audits create");
        auditPage.clickOnAudit();
        logger.log(LogStatus.PASS, "Click on Audits");
        BasePage.verifyElement(auditPage.getPopUpTitle().getText(), "Audit");
        auditPage.enterAuditName();
        logger.log(LogStatus.PASS, "Enter Audits name: " + prop.getProperty("portNumber"));
        auditPage.enterTelephoneNumbers();
        logger.log(LogStatus.PASS, "Enter Telephone: " + prop.getProperty("portNumber"));
        auditPage.clickOnSave();
        auditPage.searchAudit(prop.getProperty("portNumber"));
        auditPage.clickOnSearch();
        auditPage.verifyResult();
        auditPage.openAudit();
        auditPage.printAuditDetails();
    }
}
