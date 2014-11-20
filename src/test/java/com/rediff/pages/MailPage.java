package com.rediff.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.WebAction;
import com.framework.exception.MyException;

public class MailPage extends WebAction{
	
public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='login1']")
	private WebElement Txt_MailPage_User;
	
	@FindBy(how = How.XPATH, using = "//*[@id='div_rediffmail']/form/div[3]/input")
	private WebElement Txt_MailPage_Password;
	
	@FindBy(how = How.XPATH, using = "//*[@id='div_rediffmail']/form/div[4]/input[2]")
	private WebElement Btn_MailPage_Go;
	
	/**
	 * Purpose : Initialize MailPage object
	 * 
	 * @param driver
	 * @throws MyException
	 */
	
	public MailPage(WebDriver driver) {
		super(driver);
		AppLogs.info("MailPage() starts.."+driver.getWindowHandle()+" , "+driver.getCurrentUrl());
		this.driver = driver;
		PageFactory.initElements(driver, this);
		AppLogs.info("MailPage() ends..");
	} 
	
	/**
	 * Purpose : Click on Log In button
	 * 
	 * @throws MyException
	 */
	public void clickLogin() throws MyException {
		AppLogs.info("clickLogin() starts..");
		try {
			ClickOnWebElement(Btn_MailPage_Go);
		} catch (NoSuchElementException e) {
			throw new MyException("LoginPage -> clickLogin() - ", e);
		}
		AppLogs.info("clickLogin() ends..");
	}

	/**
	 * Purpose : Set userName in Username edit field
	 * 
	 * @param userName
	 * @throws MyException
	 */
	public void setUserName(String userName) throws MyException {
		try {
			EnterValueText(Txt_MailPage_User, userName);
		} catch (NoSuchElementException e) {
			throw new MyException("LoginPage -> setUserName() - ", e);
		}
	}

	/**
	 * Purpose : set password in Password Edit field
	 * 
	 * @param password
	 * @throws MyException
	 */
	public void setPassword(String password) throws MyException {
		try {
			EnterValueText(Txt_MailPage_Password, password);
		} catch (NoSuchElementException e) {
			throw new MyException("LoginPage -> setPassword() - ", e);
		}
	}
	
	// Buisness Flow
	/**
	 * Purpose : do login into SDG website
	 * 
	 * @param userName
	 * @param Password
	 * @throws MyException
	 */
	public void doLogin(String userName, String Password) throws MyException {
		String userName1 = "abc";
		String userName2 = "11abc";

		setUserName(userName1);
		setPassword(userName2);
		clickLogin();
	}
	
}
