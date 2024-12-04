package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import utilities.ExtentReportManager;

public class Listeners extends Base implements ITestListener {

    ExtentReports extentReport = ExtentReportManager.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTestThread.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getName();
        extentTestThread.get().log(Status.PASS, testName + " got passed");

        try {
            WebDriver driver = (WebDriver) result.getAttribute("driver");
            if (driver != null) {
                String screenshotFilePath = takeScreenshot(testName, driver);
                extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName + " is passed");
            } else {
                extentTestThread.get().log(Status.WARNING, "WebDriver instance is null. Screenshot could not be captured.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        extentTestThread.get().log(Status.FAIL, testName + " got Failed");

        try {
            WebDriver driver = (WebDriver) result.getAttribute("driver");
            if (driver != null) {
                String screenshotFilePath = takeScreenshot(testName, driver);
                extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName + " is failed");
            } else {
                extentTestThread.get().log(Status.WARNING, "WebDriver instance is null. Screenshot could not be captured.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();
        extentTestThread.remove();

    }

}
