package com.rediff.testcases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.exception.MyException;
import com.rediff.pages.HomePage;
import com.rediff.pages.MailPage;
import com.testtemplate.TestBase;

/**
 * LoginTest.java is test class for login feature test
 * @author AbhayB
 *
 */
public class LoginTest extends TestBase {
	
	MailPage mailPage = null;
	HomePage homePage = null;
	
	@BeforeClass
	@Parameters(value = {"hubAddress"})
	public void classSetUp(@Optional("localhost") String hubAddress) throws MalformedURLException, MyException {
		startWebDriver(hubAddress);
	}
	
	@BeforeMethod
	public void LoginTestSetUp(Method testName){
		try{
		AppLogs.info("LoginTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		mailPage = homePage.openRediffMail();
		readData(testName);
		AppLogs.info("LoginTestSetUp ends..");
		}catch(Exception e){
			AppLogs.error("LoginTestSetup()"+e);
		}
	}

	
	@Test(groups = { "Selenium" })
	public void sucessfullLoginTest() throws MyException {
		AppLogs.info("sucessfullLoginTest() starts..");
		mailPage.doLogin("abcd", "aaae");
		AppLogs.info("sucessfullLoginTest() ends..");
	}

	@Test(groups = { "Selenium" })
	public void rightUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamate", "qamaet");
	}

	@Test(groups = { "Selenium" })
	public void rightUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamate", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}

	@Test(groups = { "Selenium" })
	public void wrongUserNameRightPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "qamate");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}

	@Test(groups = { "Selenium" })
	public void wrongUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "qamet");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}

	@Test(groups = { "Selenium" })
	public void wrongUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}

	@Test(groups = { "Selenium" })
	public void blankUserNameRightPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "qamate");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}

	@Test(groups = { "Selenium" })
	public void blankUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "qamaet");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}

	@Test(groups = { "Selenium" })
	public void blankUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}
}
