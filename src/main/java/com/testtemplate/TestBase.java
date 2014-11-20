package com.testtemplate;

import static com.util.BrowserType.FIREFOX;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.exception.MyException;
import com.report.CaptureBrowserScreenShot;
import com.report.DetailedLogs;
import com.util.BrowserType;
import com.util.CommonFunctionLib;
import com.util.Reader;

/**
 * TestBase.java is inherited by all test classes & contains method to setup, teardown, load test data, set capabilities etc.
 * 
 * @author Abhay Bharti
 * 
 */
public class TestBase {

	private static ResourceBundle _prop = ResourceBundle.getBundle("Env");
	private static BrowserType browserType;
	protected WebDriver driver;
	
	public DetailedLogs AppLogs = new DetailedLogs();
	Reader xls = new Reader();
	
	CaptureBrowserScreenShot captureBrowserScreenShot = new CaptureBrowserScreenShot();
	
	/**
	 * Purpose : This method starts browser on available node & connect wih HUB 
	 * @param hubAddress
	 * @throws MalformedURLException
	 */
	@BeforeClass
	@Parameters("hubAddress")
	public void startDriver(@Optional("localhost") String hubAddress) throws MalformedURLException {
		AppLogs.info("startDriver starts..");
		driver = new RemoteWebDriver(new URL("http://" + hubAddress+ ":" + "4444/wd/hub"), generateDesiredCapabilities(browserType));
		
		AppLogs.debug("hubAddress : "+ hubAddress + "browserType : " +browserType);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.rediff.com/");
		AppLogs.info("startDriver ends..");
	}

	/**
	 * Purpose : This method close/quit driver once test class execution is complete
	 */
	@AfterClass
	public void stopDriver() {
		AppLogs.info("stopDriver starts..");
		driver.quit();
		driver = null;
		AppLogs.info("stopDriver ends..");
	}
	
	/**
	 * Purpose : This method reads data from TestDate file for respective test case
	 * @param testName
	 * @return
	 */
	@DataProvider
	public Object[][] readData(Method testName){
		AppLogs.info("readData starts..");
		return CommonFunctionLib.readData(testName.getName(), xls);
		
	}

	/**
	 * Purpose : This method loads browser enum from .properties file & BrowserType class before suite execution starts
	 */
	@BeforeSuite
	public void setUpTest() {
		AppLogs.info("setUpTest starts..");
		for (BrowserType browser : BrowserType.values()) {
			AppLogs.debug("Value in browser variable = "+ browser.toString());
			AppLogs.debug("_prop.getString = "	+ _prop.getString("browser"));
			if (browser.toString().toLowerCase().equals(_prop.getString("browser").toLowerCase())) {
				browserType = browser;
			}
		}
		if (browserType == null) {
			AppLogs.error("Unknown browser specified, defaulting to 'Firefox'...");
			browserType = FIREFOX;
		}
		AppLogs.info("setUpTest ends..");
	}


	/**
	 * Purpose : This method performs tearDown after a test case execution & takes browser screen shot in case of test fail
	 * @param result
	 * @throws MyException
	 * @throws IOException
	 */
	@AfterMethod
	public void TearDown(ITestResult result) throws MyException, IOException {
		AppLogs.info("TearDown starts..");
		if (!result.isSuccess()){
			captureBrowserScreenShot.embedScreenShotIntoReport(driver);
		}
		if (!(driver.getCurrentUrl()=="http://www.rediff.com/")){
			driver.get("http://www.rediff.com/");
		}
		
		AppLogs.info("TearDown ends..");
	}

	/**
	 * Purpose : This method set capability in browser
	 * @param capabilityType
	 * @return
	 */
	private DesiredCapabilities generateDesiredCapabilities(BrowserType capabilityType) {
		AppLogs.info("generateDesiredCapabilities starts..");
		DesiredCapabilities capabilities;

		switch (capabilityType) {
		case IE:
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,true);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			capabilities.setCapability("requireWindowFocus", true);
			capabilities.setBrowserName("iexplore"); 
			capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			//capability.setVersion("");
			break;
		case SAFARI:
			capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("safari.cleanSession", true);
			//capability.setVersion("");
			break;
		case OPERA:
			capabilities = DesiredCapabilities.opera();
			capabilities.setCapability("opera.arguments", "-nowin -nomail");
			//capability.setVersion("");
			break;
		case CHROME:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches",Arrays.asList("--no-default-browser-check"));
			HashMap<String, String> chromePreferences = new HashMap<String, String>();
			chromePreferences.put("profile.password_manager_enabled", "false");
			capabilities.setCapability("chrome.prefs", chromePreferences);
			//capability.setVersion("");
			break;
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox"); 
			capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			//capability.setVersion("");
			break;
		case HTMLUNIT:
		default:
			capabilities = DesiredCapabilities.htmlUnit();
			capabilities.setCapability("javascriptEnabled", "true");
		}
		AppLogs.info("generateDesiredCapabilities ends..");
		return capabilities;
	}
}


/**
 * Command to launch Hub & Node 
 * java -jar selenium-server-standalone-2.32.0.jar -role hub -port 4444
 * 
 * java -jar selenium-server-standalone-2.42.1.jar -role node -hub http://localhost:4444/grid/register -port 5555 -browser browserName=firefox -maxSession 1

java -jar selenium-server-standalone-2.42.1.jar -role node -hub http://localhost:4444/grid/register -port 5555 -browser browserName=firefox, -browser browserName=chrome, -browser browserName=iexplore -maxSession 1
   java -jar selenium-server-standalone-2.42.1.jar -role node -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox -maxSession 1
 *
 */