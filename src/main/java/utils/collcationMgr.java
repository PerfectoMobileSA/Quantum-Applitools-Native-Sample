package utils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.TestResults;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.ReportUtils;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by uzie on 1/12/17.
 */
public class collcationMgr  implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    	Eyes e = (Eyes) ConfigurationManager.getBundle().getProperty("Eyes");
    	e.open(DeviceUtils.getQAFDriver().getUnderLayingDriver(), "Sample Caculator", result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	Eyes eyes = (Eyes) ConfigurationManager.getBundle().getProperty("Eyes");
    	TestResults close = eyes.close();
		System.out.println(">>>>>> Applitools report URL: "+ close.getUrl());
		ReportUtils.logStepStart("Applitools report url");
		ReportUtils.logAssert(close.getUrl(), true);
	    // If the test was aborted before eyes.close was called, ends the test as aborted.
	    eyes.abortIfNotClosed();
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	Eyes eyes = (Eyes) ConfigurationManager.getBundle().getProperty("Eyes");
    	TestResults close = eyes.close();
		System.out.println(">>>>>> Applitools report URL: "+ close.getUrl());
		ReportUtils.logStepStart("Applitools report url");
		ReportUtils.logAssert(close.getUrl(), false);
	    // If the test was aborted before eyes.close was called, ends the test as aborted.
	    eyes.abortIfNotClosed();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.print(">>>>>> Starting Eyes driver <<<<<<<<<");
        String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools_key");
        if (null != applitoolsAPIKey) {
            Eyes eyes = new Eyes();
            eyes.setApiKey(applitoolsAPIKey);
            eyes.setMatchLevel(MatchLevel.STRICT);
            String batchName = "appium_native_test-sample-" + new Date().toString();
            eyes.setBatch(new BatchInfo(batchName));
            eyes.setLogHandler(new StdoutLogHandler(true));
            eyes.setForceFullPageScreenshot(false);
            ConfigurationManager.getBundle().setProperty("Eyes", eyes);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.print(">>>>>> END <<<<<<<<<\n");
    }
}
