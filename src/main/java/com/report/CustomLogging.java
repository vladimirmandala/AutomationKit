package com.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
public class CustomLogging extends TestListenerAdapter implements ITestListener {
  
	DetailedLogs AppLogs = new DetailedLogs();
  //Called when the test-method execution starts  
  @Override
  public void onTestStart(ITestResult result) {
        AppLogs.info("Test method started: "+ result.getName()+ " and time is: "+getCurrentTime());
   }

  //Called when the test-method execution is a success
  @Override
  public void onTestSuccess(ITestResult result) {
       AppLogs.info("Test method success: "+ result.getName()+ "  and time is: "+getCurrentTime());
  }
  
  //Called when the test-method execution fails
  @Override
  public void onTestFailure(ITestResult result) {
	  AppLogs.error("Test method failed: "+ result.getName()+ "  and time is: "+getCurrentTime());
	  
//	  Reporter.log("<br> <img src=.\\screenshots\\" + fileName  + " /> <br>");
	  //Reporter.log("<a href='"+ file.getAbsolutePath()+"/selenium-reports/html/" + result.getName() + ".jpg'> <img src='"+ file.getAbsolutePath()+"/selenium-reports/html/"+ result.getName() + ".jpg' height='100' width='100'/> </a>");
	  Reporter.log("<a href= /selenium-reports/html/" + result.getName() + ".jpg'> <img src='C:\\Users\\abhayb\\Pictures\\2014-04-24\\016.PNG'/> </a>");
  }

  //Called when the test-method is skipped
  @Override
  public void onTestSkipped(ITestResult result) {
	  AppLogs.info("Test method skipped: "+ result.getName()+ " and time is: "+getCurrentTime());    
  }

  //Called when the test-method fails within success percentage
  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // Leaving blank
    
  }

  //Called when the test in xml suite starts
  @Override
  public void onStart(ITestContext context) {
	  AppLogs.info("Test in a suite started: "+ context.getName()+ " and time is: "+getCurrentTime());
  }

  //Called when the test in xml suite finishes
  @Override
  public void onFinish(ITestContext context) {
	  AppLogs.info("Test in a suite finished: "+ context.getName()+ " and time is: "+getCurrentTime());
  }
  
  //Returns the current time when the method is called
  public String getCurrentTime(){
	  DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
	  Date dt = new Date();
    return dateFormat.format(dt);    
  }
}