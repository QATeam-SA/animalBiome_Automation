package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Instance;


public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;
    WebDriver driver = Instance.getInstance();
	
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        result.setAttribute("test", test);
        System.out.println("Executing Test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable().getMessage());

        // Capture Screenshot on Failure
        String screenshotPath = ExtentManager.captureScreenshot(driver, result.getMethod().getMethodName());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
		/* extent.flush(); */
        System.out.println("Test Execution Finished.");
    }
}