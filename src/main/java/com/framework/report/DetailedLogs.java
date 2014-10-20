package com.framework.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

/**
 * DetailedLogs.java generates log file & contains method to write log
 * @author Abhay Bharti
 *
 */
public class DetailedLogs {
	//public static org.apache.log4j.Logger AppLogs = Logger.getLogger(DetailedLogs.class);
	
	public static Logger AppLogs = Logger.getLogger(DetailedLogs.class); 

	/**
	 * Purpose : This method setup Apache Logger
	 * 
	 * @return log
	 * @throws MyException
	 */
	public DetailedLogs() {
		try {
			System.setProperty("logfile.name", System.getProperty("user.dir")
					+ "/Log/TestLog.log");
			AppLogs = Logger.getLogger(DetailedLogs.class);
			String log4JPropertyFile = System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\config\\log4j.properties";
			Properties p = new Properties();
			p.load(new FileInputStream(log4JPropertyFile));
			PropertyConfigurator.configure(p);
			AppLogs.info("SDGSeleniumFramework - Logger is configured!");
		} catch (IOException e) {
			AppLogs.error("Utitlity -> setupLogger()", e);

		}
	}

	/**
	 * Purpose : function to write debug message in execution log file
	 * 
	 * @param logstr
	 */
	public void debug(String logstr) {
		AppLogs.debug("Debug : " + logstr);
	}

	/**
	 * Purpose : function to write info message in execution log file
	 * 
	 * @param logstr
	 */
	public void info(String logstr) {
		AppLogs.info("Info : " + logstr);
	}

	/**
	 * Purpose : function to write warning message in execution log file
	 * 
	 * @param logstr
	 */
	public void warn(String logstr) {
		AppLogs.warn("Warn : " + logstr);

	}

	/**
	 * Purpose : function to write System generated exception in execution log
	 * file
	 * 
	 * @param logstr
	 */
	public void error(Exception logstr) {
		AppLogs.error("Exception Error : " + logstr);
	}

	/**
	 * Purpose : function to write error message in execution log file
	 * 
	 * @param logstr
	 */
	public void error(String logstr) {
		AppLogs.error("Error : " + logstr);
	}

	/***
	 * 
	 * @param location
	 */
	public void CreateFolder(String location) {
		new File(location).mkdir();
	}

	public void Report(String str) {
		Reporter.log(str);
	}

	public void Report(String Expected, String Actual, String str) {
		if (Actual.equals(Expected)) {
			Reporter.log("Expected : " + Expected + " Found : " + Actual);
			debug("Expected : " + Expected + " Found  : " + Actual);
		} else {
			Reporter.log("Expected : " + Expected + " Found : " + Actual
					+ "Error : " + str);
			error("Expected : " + Expected + " Found  : " + Actual + "Error : "
					+ str);

			// Reporter.log("<img src=\"file:///" + str + filename +
			// "\" alt=\"\"/><br />");
		}
	}

	public void Report(String Expected, String Actual) {
		if (Actual.equals(Expected)) {
			Reporter.log("Expected : " + Expected + " Found : " + Actual);
		} else {
			Reporter.log("Expected : " + Expected + " Found : " + Actual);
		}
	}
}
