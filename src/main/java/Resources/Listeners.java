package Resources;

import TestComponents.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.MalformedURLException;

public class Listeners extends TestBase implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        Object testClass = result.getInstance();
        try {
            driver = ((TestBase) testClass).initialization();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot(driver), result.getMethod().getMethodName()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.info("Test failed but it is in defined success ratio");
    }

    @Override
    public void onStart(ITestContext context) {
        Log.builder().details("I am in onStart method " + test);
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }
}
