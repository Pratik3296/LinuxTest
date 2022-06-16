package com.genericUtils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

import static com.genericUtils.AutoConstants.EXPLICIT_WAIT;
import static org.testng.Assert.assertEquals;

public class BasePage extends BaseTest {
    /* captureScreenshot() return the screenshot of current page*/
    public static File captureScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) (driver);
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Execution Status/ScreenShots/" + name + currentTime() + 100000000 + new Random().nextInt(900000000) + ".png";
        informationPrint("ScreenShot is accessible in " + path);
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return dest;
    }
    public static void takeScreenShortAndFail( WebElement element) throws IOException {
        File Path = BasePage.captureScreenshot(driver,  "Element " + BasePage.currentDateAndTime());
        String screenshotPath = Path.getPath();
        screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/Execution Status/ScreenShots/Element issue/", "");
        logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        logger.log(LogStatus.FAIL, element.toString()+" is not Expected ");
    }
    public static void takeScreenShortAndPrintInfo( WebElement element) throws IOException {
        File Path = BasePage.captureScreenshot(driver,  "Element " + BasePage.currentDateAndTime());
        String screenshotPath = Path.getPath();
        screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/Execution Status/ScreenShots/Element issue/", "");
        logger.log(LogStatus.WARNING, logger.addScreenCapture(screenshotPath));
        logger.log(LogStatus.WARNING, element.toString()+" is not accessible ");
    }
    public static void informationPrint(String info) {
        logger.log(LogStatus.INFO, info);
    }

    /* currentTime() will return only current time*/
    public static String currentTime() {
        DateFormat date = new SimpleDateFormat("MM_dd");
        Date currentDate = new Date();
        Date time = Calendar.getInstance().getTime();
        return date.format(currentDate).replace("_", "").concat(String.valueOf(time.getHours())).concat(String.valueOf(time.getMinutes()));
    }

    public static String currentDateAndTime() {
        DateFormat date = new SimpleDateFormat("MM_dd_yyyy");
        Date currentDate = new Date();
        return date.format(currentDate).concat(String.valueOf(date.getCalendar().getInstance().getTime())).replace(" ", "").replace(":", "");
    }

    public static String getTitle(String title) {
        waitForPageLoad();
        String actualTitle = null;
        Boolean result = elementIsVisible("//i[@class='fas fa-home']/../../..//li[.='" + title + "']");
        if (result) {
            actualTitle = driver.findElement(By.xpath("//i[@class='fas fa-home']/../../..//li[.='" + title + "']")).getText();
        }
        return actualTitle;
    }
    public static void verifyElement(String expectedResult, String actualResult ){
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(actualResult,expectedResult);
            logger.log(LogStatus.PASS, "Actual value is  matching with Expected Value: " + expectedResult);
        } catch (Exception e) {
            logger.log(LogStatus.WARNING, "Actual value is not matching with Expected Value; Actual value is : " + actualResult);
            softAssert.fail("Actual value is not matching with Expected Value");
        }
    }
    public static String generateNewPortNumber() throws IOException {
        String portNumber=prop.getProperty("portNumber");
        long number = Long.parseLong(portNumber);
        portNumber=Long.toString(number+1);
        String path = System.getProperty("user.dir") + "/src/test/resources/config/project.properties";
        FileOutputStream fis = new FileOutputStream(path);
        prop.setProperty("portNumber", portNumber);
        prop.store(fis, "Test-Data");
        fis.close();
        return portNumber;
    }
    public static void verifyTitle(String expectedTitle) {
        waitForPageLoad();
        // compare Current title with expected title
        try {
            assertEquals(getTitle(expectedTitle), expectedTitle);
            logger.log(LogStatus.PASS, "Title is matching: " + expectedTitle);
        } catch (Exception e) {
            logger.log(LogStatus.WARNING, "Title is not matching; Expected title is : " + expectedTitle);
            logger.log(LogStatus.WARNING, "Actual title is: " + driver.getTitle());
            SoftAssert softAssert = new SoftAssert();
            softAssert.fail("Title not matching");
        }

    }
    public static void verifySectionTitle(String expectedSectionTitle) {
        waitForPageLoad();
        // compare Current title with expected title
        try {
            assertEquals(getTitle(expectedSectionTitle), expectedSectionTitle);
            logger.log(LogStatus.PASS, "Title is matching: " + expectedSectionTitle);
        } catch (Exception e) {
            logger.log(LogStatus.WARNING, "Title is not matching; Expected title is : " + expectedSectionTitle);
            logger.log(LogStatus.WARNING, "Actual title is: " + driver.getTitle());
            SoftAssert softAssert = new SoftAssert();
            softAssert.fail("Title not matching");
        }

    }

    public static Boolean elementIsVisible(String xpath) {
        waitForPageLoad();
        boolean result;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = true;
        } catch (Exception exception) {
            informationPrint(String.valueOf(exception));
            result = false;
        }
        return result;
    }
    public static boolean  getElement(WebElement element){
        waitForPageLoad();
        boolean result;
        try {
            scrollTillElement(element);
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch (Exception exception) {
            informationPrint(String.valueOf(exception));
            result = false;
        }
        return result;
    }

    public static void pageRefresh() {
        try {
            driver.navigate().refresh();
            waitForPageLoad();
        }
        catch (Exception exception){}
    }

    public static void navigateToBackPage() {
        driver.navigate().back();
        waitForPageLoad();
    }

    public static void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver,(EXPLICIT_WAIT));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
        new Actions(driver).pause(2000).build().perform();
    }
    public static void zoomInPageAndTakeScreenShort(WebElement element) throws IOException {
        pageZoomIn();
        takeScreenShortAndPrintInfo(element);
        pageZoomSetBackToNormal();
    }
    public static void elementClick(WebElement element) throws IOException {
        waitForPageLoad();
        if(getElement(element)){
            builder.moveToElement(element).click(element).build().perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }

    }
    public static void elementClear(WebElement element) throws IOException {
        waitForPageLoad();
        if(getElement(element)){
            builder.moveToElement(element).click(element).keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE)
                    .build()
                    .perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
    }
    public static void enterValue(WebElement element, String value) throws IOException {
        waitForPageLoad();
        if(getElement(element)){
            builder.click(element).sendKeys(value).build().perform();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
    }
    public static void scrollTillElement(WebElement element){
        waitForPageLoad();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static String getValueOfElement(WebElement element) throws IOException {
        String value = null;
        if(getElement(element)){
            scrollTillElement(element);
            value=element.getText();
        }
        else {
            zoomInPageAndTakeScreenShort(element);
        }
        return  value;
    }
    public static  void pageZoomIn(){
        for(int i=0; i<4; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        }
    }
    public static  void pageZoomSetBackToNormal(){
        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }
    public static void selectByVisibleText(WebElement element, String text){
        waitForPageLoad();
        try{
            Select select=new Select(element);
            select.selectByVisibleText(text);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectByIndex(WebElement element, int index){
        waitForPageLoad();
        try{ Select select=new Select(element);
            select.selectByIndex(index);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectByValue(WebElement element, String value){
        waitForPageLoad();
        try{ Select select=new Select(element);
            select.selectByValue(value);}
        catch (Exception exception){
            logger.log(LogStatus.INFO, "Empty dropdown");
        }
    }
    public static void selectFromList(WebElement element, String value) throws IOException {
        waitForPageLoad();
        Select select=new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option:options) {
            if(option.getText().equalsIgnoreCase(value)){
                elementClick(option);
                break;
            }
        }

    }

    public static WebElement givenList_shouldReturnARandomElement(List<WebElement> elements) {
        waitForPageLoad();
        List<WebElement>givenList = new ArrayList<>(elements);
        Random rand = new Random();
        WebElement randomElement = givenList.get(rand.nextInt(givenList.size()-1));
        return randomElement;
    }
    public static String randomName(String nameStartWith){
        waitForPageLoad();
        Random rand = new Random();
        return nameStartWith.concat(String.valueOf(rand.nextInt(1000)));
    }
    public static String randomAccountNumberGeneration(){
        waitForPageLoad();
        Random random = new Random();
        return String.format("%011d", random.nextInt(1000000000));
    }
    public static String randomBillingTelephoneNumber(){
        waitForPageLoad();
        Random random = new Random();
        return String.format("%010d", random.nextInt(1000000000));
    }
    public static void fileUpdate(String fileName, int row)  {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/upload/"+fileName);
            System.out.println(System.getProperty("user.dir")+"/src/test/resources/upload/"+fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;
            for (int i = 0; i < row; i++) {
                //Retrieve the row and check for null
                XSSFRow sheetrow = sheet.getRow(i);
                if(sheetrow == null){
                    sheetrow = sheet.createRow(i);
                }
                //Update the value of cell
                cell = sheetrow.getCell(0);
                if(cell == null){
                    cell = sheetrow.createCell(0);
                }
                builder.pause(2000).perform();
                cell.setCellValue(generateNewPortNumber());

            }

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File(System.getProperty("user.dir")+"/src/test/resources/upload/"+fileName));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void loginToApplication(String userName, String password) throws IOException {
    loginPage.setUserName(userName);
    logger.log(LogStatus.PASS,"Entered userName is "+userName);
    loginPage.setPassword(password);
    logger.log(LogStatus.PASS,"Entered password");
    loginPage.clickOnSubmit();
    logger.log(LogStatus.PASS,"Click on submit");

}

}