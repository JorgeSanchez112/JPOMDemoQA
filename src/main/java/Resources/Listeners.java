package Resources;

import TestComponents.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public String takeScreenshot(WebDriver driver) throws IOException {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            return screenshot.getScreenshotAs(OutputType.BASE64);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return null;
    }

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
        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = ((TestBase) result.getInstance()).getDriver();
        if (driver != null) {
            try {
                try{
                    String base64Screenshot = takeScreenshot(driver);
                    extentTest.get().addScreenCaptureFromBase64String(base64Screenshot);
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
