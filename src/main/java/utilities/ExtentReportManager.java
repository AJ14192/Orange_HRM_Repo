package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    public static ExtentReports extentReports;

    public static ExtentReports getExtentReport() {

        String extentReportFilePath = System.getProperty("user.dir") + "\\reports\\extentReport.html";
        File reportsFolder = new File(System.getProperty("user.dir") + "\\reports");
        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs(); // Create the reports folder
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportFilePath);
        reporter.config().setDocumentTitle("Test Result");
        reporter.config().setReportName("Automated Test Result");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Operating System", "Windows 11");
        extentReports.setSystemInfo("Tested By", "Ankit Jadeja");

        return extentReports;
    }

}
