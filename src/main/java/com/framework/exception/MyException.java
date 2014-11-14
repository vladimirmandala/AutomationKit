package com.framework.exception;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;

import com.framework.report.DetailedLogs;


/**
 * MyExeption.java
 * Purpose: This class contains user defined exception handling methods  
 * 
 * @author : Abhay Bharti
 * @version 1.0 21/05/14
 */
public class MyException extends Exception {
	private static final long serialVersionUID = 6040492068655004146L;
	String message;
	DetailedLogs AppLogs = new DetailedLogs();

	/**
	 * Purpose : Custom message for the exception will be set here.
	 * @param message custom exception message
	 */
	public MyException(String message) {
		super(message);
		this.message = message;
		AppLogs.error(this.message);
	}

	/**
	 * Purpose : Custom message for the Throwable will be set here.
	 * @param message custom exception message
	 */
	public MyException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Purpose : Custom message for the message and Throwable will be set here.
	 * @param message custom exception message
	 */	public MyException(String message,Throwable cause) {
		super(message);
		this.message = message;
		AppLogs.error(this.message);
	}

	/**
	 * Purpose : overloaded constructor to accept custom message and exception object
	 * @param message
	 * @param exe
	 */
	public MyException(String message , Exception exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : overloaded constructor to accept custom message and exception object
	 * @param message
	 * @param exe
	 */
	public MyException(String message , MalformedURLException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : overloaded constructor to accept custom message and exception object
	 * @param message
	 * @param exe
	 */
	public MyException(String message , NullPointerException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	
	/**
	 * Purpose : overloaded constructor to accept custom message and exception object
	 * @param message
	 * @param exe
	 */
	public MyException(String message , IOException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	public MyException(String message , IllegalArgumentException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : If selenium tries to find an element but element is not visible within page
	 * @param message
	 * @param exeception
	 */
	public MyException(String message , ElementNotVisibleException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : If user tries to handle an alert box but alert is not present.
	 * @param message
	 * @param exeception
	 */
	public MyException(String message , NoAlertPresentException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : While trying to get attribute value but attribute is not available in DOM.
	 * @param message
	 * @param exeception
	 */
	public MyException(String message , NoSuchAttributeException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : This exception is due to accessing an element which is not available in the page.
	 * @param message
	 * @param exeception
	 */
	public MyException(String message , NoSuchElementException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : Exception comes when code is unable to initialize WebDriver.
	 * @param message
	 * @param exeception
	 */
	public MyException(String message , WebDriverException exeception) {
		super(message);
		this.message = message + exeception.getMessage();
		AppLogs.error(this.message);
	}
	
	/**
	 * Purpose : This is an overridden method which is used to fetch the custom exception message
	 */
	@Override
	public String getMessage() {
		return message;
	}
	
}