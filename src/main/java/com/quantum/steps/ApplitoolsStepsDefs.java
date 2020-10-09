/**
 * 
 */
package com.quantum.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.applitools.eyes.FixedCutProvider;
import com.applitools.eyes.selenium.Eyes;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class ApplitoolsStepsDefs {
	@Then("I check window \"(.*?)\"")
	public void checkWindow(String tag) {applitoolsCheckWindow(tag, false);}


	@Then("I check complete window \"(.*?)\"")
	public void checkCompleteWindow(String tag) {applitoolsCheckWindow(tag, true);}


	public static String getDevicePropertyInfo(String propertyName) {
		Map<String, Object> params = new HashMap<>();
		params.put("property", propertyName);
		String result = (String) DeviceUtils.getQAFDriver().executeScript("mobile:handset:info", params);
		return result;
	}


	public void applitoolsCheckWindow(String tag, boolean fullPageScreenshot) {
		Object o = ConfigurationManager.getBundle().getObject("Eyes");
		if (null != o) {
			Eyes e = (Eyes) o;
			AppiumDriver orgDriver = DriverUtils.getAndroidDriver();
			if (!e.getIsOpen()) {
				if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
					 e.open(orgDriver, orgDriver.getCurrentUrl(), "Demo");
				else
					 e.open(orgDriver, "settings", "Demo");
			}
			try {
				if (fullPageScreenshot)
					e.setForceFullPageScreenshot(true);
				e.checkWindow(tag);
			} catch (Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
}