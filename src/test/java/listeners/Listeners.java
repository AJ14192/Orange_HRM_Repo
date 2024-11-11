package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {

    WebDriver driver = null;
    ExtentReports extentReport = ExtentReporter.getExtentReport();
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
        extentTestThread.get().log(Status.PASS,testName+" got passed");

        try {
            // Get the WebDriver instance from the test class
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            // Take a screenshot
            String screenshotFilePath = takeScreenshot(testName, driver);
            // Add the screenshot to the report
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName+" Test is Passed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        extentTestThread.get().fail(result.getThrowable());

        try {
            // Accessing driver using reflection
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

            // Taking screenshot
            String screenshotFilePath = takeScreenshot(testName, driver);

            // Adding screenshot to the report
            extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName + " Test Failed");

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

    }

}
