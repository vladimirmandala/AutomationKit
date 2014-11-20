package com.rediff.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actions.WebAction;
import com.exception.MyException;

public class HomePage extends WebAction{
	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='homewrapper']/div[5]/a[1]/div/u")
	public WebElement Lnk_Homepage_Rediffmail;
	
	/**
	 * Purpose : Initialize HomePage object, verifies SDG Login page is opened
	 * 
	 * @param driver
	 * @throws MyException
	 */
	public HomePage(WebDriver driver) throws MyException {
		super(driver);
		AppLogs.info("HomePage() starts..");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!driver.getTitle().contains("Rediff")) {
			throw new MyException("This is not the Home page");
		}
		AppLogs.info("HomePage() ends..");
	} 
	 public MailPage openRediffMail(){
		 AppLogs.info("openRediffMail() starts..");
		 ClickOnWebElement(Lnk_Homepage_Rediffmail);
		 SwitchToBrowser("http://www.rediff.com/");
		 return PageFactory.initElements(driver, MailPage.class);
		 
		 
		 
	 }
	
}