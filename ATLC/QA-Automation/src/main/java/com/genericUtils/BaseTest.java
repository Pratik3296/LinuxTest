package com.genericUtils;

import com.pages.login.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.genericUtils.AutoConstants.*;

public class BaseTest {
    public static ExtentReports extent;
    public static Properties prop;
    public static ExtentTest logger;
    public static WebDriver driver;
    public static InputStream fileInput;
    public  static WebDriverWait wait;
    public static Actions builder;
    public static JavascriptExecutor js;
    public static  LoginPage loginPage;
    @BeforeTest
    public void preconditions() throws IOException {
        prop=new Properties();
        String filepath1=System.getProperty("user.dir")+"/src/test/resources/config/project.properties";
        fileInput = new FileInputStream(filepath1);
        prop.load(fileInput);
        System.setProperty(CHROME_DRIVER_KEY, CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        // Instantiate the chrome driver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,(EXPLICIT_WAIT));
        driver.manage().window().maximize();
        builder=new Actions(driver);
        js = (JavascriptExecutor) driver;
        extent = new ExtentReports(System.getProperty("user.dir") + "/Execution Status/Extent Reports/"+"ATLC".concat("_"+BasePage.currentDateAndTime())+".html", true);
        extent.addSystemInfo("Executed By ", prop.getProperty("userName"));
        extent.addSystemInfo("Environment", prop.getProperty("url"));
        extent.loadConfig(new File(System.getProperty("user.dir") + "/Execution Status/Extent Reports/"+"ATLC".concat("_"+BasePage.currentDateAndTime())+ ".html"));
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(ITestResult res) throws IOException {
        if (res.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, res.getTestClass().getName() + " is Passed ");
        } else if (res.getStatus() == ITestResult.FAILURE) {
            String name = res.getName();
            System.out.println(name+" test class name");
            File Path = BasePage.captureScreenshot(driver, name + " " + BasePage.currentDateAndTime());
            String screenshotPath = Path.getPath();
            screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/Execution Status/ScreenShots/"+"ATLC"+"/", "");
            System.out.println(screenshotPath);
            logger.log(LogStatus.FAIL, "" + res.getThrowable());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
            logger.log(LogStatus.FAIL, res.getTestClass().getName() + " is Failed ");
        } else if (res.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, res.getTestClass().getName() + " is Skipped");
        }
        extent.endTest(logger);

    }
    @AfterTest
    public void postConditions() throws InterruptedException {
        extent.flush();
        extent.close();
        /*Logout method should call*/
        Thread.sleep(10000);
//        loginPage.logOutSteps();
//        driver.close();

    }

}

