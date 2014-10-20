package com.mobile.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.exception.MyException;
import com.framework.testtemplate.TestBase;

public class MobilTest extends TestBase{
	
	@BeforeClass
	@Parameters(value = {"Mobile","Device"})
	public void classSetUp(@Optional("Yes") String Mobile, @Optional("Android") String Device) throws MalformedURLException, MyException {
		startAppiumDriver(Mobile,Device);
	}
	
	@Test(groups = { "Mobile" })
	public void TestOne(){
		AppLogs.info("sucessfullLoginTest() starts..");
	}
}
