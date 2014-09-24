package com.rediff.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exception.MyException;
import com.rediff.pages.HomePage;
import com.testtemplate.TestBase;

public class HomePageTest extends TestBase{
	HomePage homePage = null;
	
	@BeforeMethod
	public void HomePageTestSetUp(Method testName){
	  try{
		homePage = PageFactory.initElements(driver, HomePage.class);
		AppLogs.info("LoginTestSetUp ends..");
		}catch(Exception e){
			AppLogs.error("LoginTestSetup()"+e);
		}
		AppLogs.info("-------------" + testName.getName()+" ---------- Test Case starts..");
	}
	
	@Test
	public void verifyBrokenLink() throws MyException{
		homePage.CheckHyperLinkOnPage();
	}
}
