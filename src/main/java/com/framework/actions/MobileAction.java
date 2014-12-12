package com.framework.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * MobileAction.java is for interacting with mobile objects. Page objects re-use these utilities to perform functions relevant to test steps. 
 * 
 * @author : Abhay Bharti
 * @version 1.0 22/09/14
 */
public class MobileAction{
/*    startActivity()
    resetApp()
    getAppString()
    sendKeyEvent()
    currentActivity()
    pullFile()
    pushFile()
    pullFolder()
    hideKeyboard()
    runAppInBackground()
    performTouchAction()
    performMultiTouchAction()
    tap()
    swipe()
    pinch()
    zoom()
    getNamedTextField()
    isAppInstalled()
    installApp()
    removeApp()
    launchApp()
    closeApp()
    endTestCoverage()
    lockScreen()
    isLocked()
    shake()
    complexFind()
    scrollTo()
    scrollToExact()
    openNotifications()
    Context Switching: .context(), .getContextHandles(), getContext())
    getNetworkConnection(), setNetworkConnection()
    ignoreUnimportantViews(), getSettings()
*/
	@AndroidFindBy(className = "android.webkit.WebView")
	private WebElement androidWebView;

	public AppiumDriver driver;

	public MobileAction(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void loadPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void rotateScreen() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		// TODO Auto-generated method stub
	}

	public void switchToWebView() {
		//driver.manage().timeouts().implicitlyWait(AppUtils.DEFAULT_WAIT_TIME,TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,AppUtils.EXPLICIT_WAIT_TIME);
		//wait.until(ExpectedConditions.visibilityOf(androidWebView));
		//driver.manage().timeouts().implicitlyWait(AppUtils.EXPLICIT_WAIT_TIME,TimeUnit.SECONDS);

		Set<String> contextSet = driver.getContextHandles();
		for (String contextName : contextSet) {
			System.out.println(contextName);
			if (!contextName.contains("NATIVE_APP")) {
				driver.context(contextName);				
				break;
			}
		}
	}

	public void takeScreenShot(String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fileName + ".png");
		File tmpFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmpFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
