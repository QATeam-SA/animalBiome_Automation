package util;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Test Suite Execution Started: " + suite.getName());
        ExtentManager.getInstance(); 
    }

    @Override
    public void onFinish(ISuite suite) {
    	int passed = 0, failed = 0, skipped = 0;
    	for (ISuiteResult result : suite.getResults().values()) {
            ITestContext context = result.getTestContext();
            passed += context.getPassedTests().size();
            failed += context.getFailedTests().size();
            skipped += context.getSkippedTests().size();
        }
        System.out.println("Test Suite Execution Finished: " + suite.getName());
        ExtentManager.flushReports();
        EmailReport.sendReportEmail(passed, failed, skipped);
    }
}
