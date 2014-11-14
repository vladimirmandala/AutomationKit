package com.rediff.testcases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.exception.MyException;
import com.framework.testtemplate.TestBase;
import com.rediff.pages.HomePage;
import com.rediff.pages.MailPage;

/**
 * LoginTest.java is test class for login feature test
 * @author AbhayB
 *
 */
public class LoginTest extends TestBase {
	
	protected LoginTest() throws MyException {
		super();
		// TODO Auto-generated constructor stub
	}

	MailPage mailPage = null;
	HomePage homePage = null;
	
	@BeforeClass(alwaysRun = true)
	@Parameters(value = {"hubAddress"})
	public void classSetUp(@Optional("localhost") String hubAddress) throws MalformedURLException, MyException {
		startWebDriver(hubAddress);
	}
	
	@BeforeTest(alwaysRun = true)
	public void before(){
		 initLogs(this.getClass());
	}
	
	@BeforeMethod(alwaysRun = true)
	public void LoginTestSetUp(Method testName){
		try{
		AppLogs.info("LoginTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		mailPage = homePage.openRediffMail();
		//readData(testName);
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

	@Test(groups = { "Selenium" },dataProvider="readData")
	public void blankUserNameBlankPasswordLoginTest(Hashtable<String,String> data) throws MyException {
		mailPage.doLogin("", "");
		System.out.println(data.get("Username") + data.get("Password"));
		mailPage.doLogin(data.get("Username"), data.get("Password"));
		
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}
}
