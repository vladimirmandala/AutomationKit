package com.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.framework.exception.MyException;


public class CaptureBrowserScreenShot{
	
	DetailedLogs AppLogs = new DetailedLogs();

	
	public CaptureBrowserScreenShot(){
		
	}
	
/**
 * Purpose : This method generates unique file name
 * 
 * @return GetDateTime
 * @throws MyException
 */
private String getDateTime() throws MyException {
	AppLogs.info("TestBase -> getDateTime() - starts..");
	try {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String strTime = sdfTime.format(now);
		strTime = strTime.replace(":", "-");
		AppLogs.info("TestBase -> getDateTime() - ends..");
		return (strDate + "_" + strTime);
	}
	catch (Exception e) {
		throw new MyException("TestBase -> getDateTime() - ", e);
	}
}

/**
 * Purpose : This method takes screenshot
 * 
 * @throws IOException 
 * @throws Exception 
 */
private File takeScreenShots(WebDriver driver) throws MyException, IOException {
	AppLogs.info("TestBase -> takeScreenShots() - starts..");
    try {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File stored = new File(System.getProperty("user.dir")+ "\\Report\\Screenshot\\" + getDateTime() + ".png");
        FileUtils.copyFile(temp, stored);
        AppLogs.info("TestBase -> takeScreenShots() - ends..");
        return stored;
    }catch (WebDriverException somePlatformsDontSupportScreenshots) {
    	throw new MyException("TestBase -> takeScreenShots() - ", somePlatformsDontSupportScreenshots);
    }catch(IOException e){
    	throw new MyException("TestBase -> takeScreenShots() - ", e);
    }
}

/**
 * Purpose : This method embeds screenshot into Cucumber Jenkins report
 * 
 * @param scenario
 * @throws MyException
 * @throws IOException 
 */
 public void embedScreenShotIntoReport(WebDriver driver) throws MyException, IOException{
	AppLogs.info("TestBase -> embedScreenShotIntoReport() - starts..");
	     try {  
	    	 takeScreenShots(driver);
         } catch (WebDriverException wde) {  
        	 throw new MyException("TestBase -> embedScreenShotIntoReport() - ", wde);
         } catch (ClassCastException cce) {  
        	 throw new MyException("TestBase -> embedScreenShotIntoReport() - ", cce);
         } catch(IOException Io){
        	 throw new MyException("TestBase -> embedScreenShotIntoReport() - ", Io);
         } catch(Exception e){
        	 throw new MyException("TestBase -> embedScreenShotIntoReport() - ", e);
         }
     AppLogs.info("TestBase -> embedScreenShotIntoReport() - ends..");
  }  
}