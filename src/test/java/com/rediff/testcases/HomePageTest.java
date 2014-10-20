package com.rediff.testcases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.exception.MyException;
import com.framework.testtemplate.TestBase;
import com.rediff.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage = null;
	
	
	@BeforeClass
	@Parameters(value = {"hubAddress"})
	public void classSetUp(@Optional("localhost") String hubAddress) throws MalformedURLException, MyException {
		startWebDriver(hubAddress);
	}
	
	@BeforeMethod
	public void HomePageTestSetUp(Method testName){
		AppLogs.info("HomePageTestSetUp class ends..");
		try{
			homePage = PageFactory.initElements(driver, HomePage.class);
			readData(testName);
			AppLogs.info("HomePageTestSetUp class ends..");
		}catch(Exception e){
			AppLogs.error("LoginTestSetup()"+e);
		}
		AppLogs.info("-------------" + testName.getName()+" ---------- Test Case starts..");
	}
	
	
	@Test(groups = { "Selenium" })
	public void verifyBrokenLink() throws MyException{
		homePage.CheckHyperLinkOnPage();
	}
}
