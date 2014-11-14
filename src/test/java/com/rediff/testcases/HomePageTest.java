package com.rediff.testcases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

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
	HomePageTest() throws MyException {
		super();
		// TODO Auto-generated constructor stub
	}


	HomePage homePage = null;
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters(value = {"hubAddress"})
	public void classSetUp(@Optional("localhost") String hubAddress) throws MalformedURLException, MyException {
		startWebDriver(hubAddress);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void HomePageTestSetUp(Method testName){
		AppLogs.info("HomePageTestSetUp class ends..");
		try{
			homePage = PageFactory.initElements(driver, HomePage.class);
			AppLogs.info("HomePageTestSetUp class ends..");
		}catch(Exception e){
			AppLogs.error("HomePageTestSetUp()"+e);
		}
		AppLogs.info("-------------" + testName.getName()+" ---------- Test Case starts..");
	}
	
	
	@Test(groups = { "Selenium" })
	public void verifyBrokenLink() throws MyException{
		homePage.CheckHyperLinkOnPage();
	}
}
