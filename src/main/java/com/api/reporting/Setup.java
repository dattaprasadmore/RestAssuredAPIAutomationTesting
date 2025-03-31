package com.api.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        if(extentReports==null) {
            String fileName = ExtentReportManager.getReportNameWithTimeStamp();
            String fullReportPAth = System.getProperty("user.dir") + "\\reports\\" + fileName;
            extentReports = ExtentReportManager.createInstance(fullReportPAth, "Test API Automation Report", "Test Execution Report");
        }
    }

    public void onFinish(ITestContext context) {
    if(extentReports!= null){
        extentReports.flush();
    }
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(" Test Name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",","<br>");
        String formatedStackTrace = "<details>\n" +
                "<summary>Click Here for more detsils</summary>\n" +
                "" + stackTrace + "\n" +
                "</details>";
        ExtentReportManager.logExceptionDetails(formatedStackTrace);
    }

}
