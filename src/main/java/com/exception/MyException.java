package com.exception;

import java.io.IOException;
import java.net.MalformedURLException;

import com.report.DetailedLogs;


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
	public MyException(String message , IOException exeception) {
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