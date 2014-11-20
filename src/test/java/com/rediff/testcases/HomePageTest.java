package com.rediff.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.pages.HomePage;
import com.rediff.pages.MailPage;
import com.testtemplate.TestBase;

public class HomePageTest extends TestBase{

	MailPage mailPage = null;
	HomePage homePage = null;
		
	@BeforeMethod
	public void LoginTestSetUp(){
		try{
		AppLogs.info("LoginTestSetUp starts..");
		homePage = PageFactory.initElements(driver, HomePage.class);
		AppLogs.info("LoginTestSetUp ends..");
		}catch(Exception e){
			AppLogs.error("LoginTestSetup()"+e);
		}
	}
	
	@Test()
	public void TestBrokenLink(){
		
	}
}
