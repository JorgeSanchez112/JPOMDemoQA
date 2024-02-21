package Resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private final int maxRetries = 3;
    private final int retryDelaySeconds = 1;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetries) {
            System.out.println("Retrying test: " + result.getName() + " for the " + (retryCount + 1) + " time.");
            retryCount++;

            sleep();
            return true;
        }
        return false;
    }

    private void sleep() {
        try {
            Thread.sleep(retryDelaySeconds * 1000L);
        } catch (InterruptedException ignored) {
        }
    }

}
