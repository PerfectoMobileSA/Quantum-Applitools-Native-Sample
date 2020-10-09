package utils;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.StdoutLogHandler;
//import com.applitools.eyes.Eyes;
//import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.qmetry.qaf.automation.core.ConfigurationManager;

public class collcationMgr  implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

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
           Eyes e = new Eyes();
            e.setApiKey(applitoolsAPIKey);
            e.setMatchLevel(MatchLevel.STRICT);
            String batchName = "appium_native_test-sample-" + new Date().toString();
            e.setBatch(new BatchInfo(batchName));
            e.setLogHandler(new StdoutLogHandler(true));
            e.setForceFullPageScreenshot(false);
            ConfigurationManager.getBundle().setProperty("Eyes", e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.print(">>>>>> END <<<<<<<<<\n");
        String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools_key");
        if (null != applitoolsAPIKey) {
            Eyes e = (Eyes)ConfigurationManager.getBundle().getObject("Eyes");
            TestResults close = e.close();
            System.out.println(">>>>>> Applitools report URL: "+ close.getUrl());
            e.abortIfNotClosed();
        }
    }
}
