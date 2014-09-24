package com.rediff.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
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
		
	@BeforeMethod
	public void LoginTestSetUp(){
		try{
		AppLogs.info("LoginTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		mailPage = homePage.openRediffMail();
		AppLogs.info("LoginTestSetUp ends..");
		}catch(Exception e){
			AppLogs.error("LoginTestSetup()"+e);
		}
	}
	
	@Test
	public void sucessfullLoginTest() throws MyException {
		AppLogs.info("sucessfullLoginTest() starts..");
		mailPage.doLogin("abcd", "aaae");
		AppLogs.info("sucessfullLoginTest() ends..");
	}

	@Test
	public void rightUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamate", "qamaet");
	}

	@Test
	public void rightUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamate", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}

	@Test
	public void wrongUserNameRightPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "qamate");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}

	@Test
	public void wrongUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "qamet");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}

	@Test
	public void wrongUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("qamaet", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}

	@Test
	public void blankUserNameRightPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "qamate");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}

	@Test
	public void blankUserNameWrongPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "qamaet");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}

	@Test
	public void blankUserNameBlankPasswordLoginTest() throws MyException {
		mailPage.doLogin("", "");
		// Assert.assertTrue(HomePage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}
}
