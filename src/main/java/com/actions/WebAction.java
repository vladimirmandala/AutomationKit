package com.actions;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.exception.MyException;
import com.report.DetailedLogs;

/**
 * WebAction.java is for interacting with browser objects. Page objects re-use these utilities to perform functions relevant to test steps. 
 * 
 * @author : Abhay Bharti
 * @version 1.0 21/09/14
 */
public abstract class WebAction {
	protected WebDriver driver = null;
	protected DetailedLogs AppLogs = null;
	final int waitvalue = 10;
	Actions builder = null;
	
	
	/**
	 * Constructor to initialize WebAction class objects
	 * @param driver
	 */
	public WebAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		builder = new Actions(this.driver);
		AppLogs = new DetailedLogs();
	}


	
	/**
	 * Purpose: This method get all the attributes of a WebElement
	 * @param object
	 * @param attribute
	 */
	public void ReadFromWebElement(WebElement object, String attribute) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getAttribute(attribute);
		AppLogs.info("ReadFromWebElement ends..");
	}

	/**
	 * Purpose : This method enters text in Input box
	 * @param object
	 * @param input
	 */
	public void EnterValueText(WebElement object,String input) {
		AppLogs.info("EnterValueText starts..");
		object.clear();
		object.sendKeys(input);
		AppLogs.info("EnterValueText ends..");
	}

	/**
	 * Purpose : This method Type special key like Shift,Backspace, Enter, Tab, Shift,
	 * @param object
	 * @param input
	 */
	public void EnterValueTextWithShit(WebElement object,String input) {
		AppLogs.info("EnterValueTextWithShit starts..");
		object.sendKeys(Keys.chord(Keys.SHIFT,input));
		AppLogs.info("EnterValueTextWithShit ends..");
	}
	
	/**
	 * Purpose : This is used to fetch the CSS properties' values of the given element. CSS properties
	 * can be font-family, background-color, color, and so on.
	 * @param object
	 * @param ProprertyName
	 */
	public void ReadCSSFromWebElement(WebElement object, String ProprertyName) {
		AppLogs.info("ReadCSSFromWebElement starts..");
		object.getCssValue(ProprertyName);
		// getCssValue("font-family"));
		// getCssValue("background-color"));
		AppLogs.info("ReadCSSFromWebElement ends..");
	}

	/***
	 * Purpose : This is used to get the relative position of an element where it is rendered on
	 * the web page.
	 * @param object
	 */
	public void WeGetLocation(WebElement object) {
		AppLogs.info("WEGetLocation starts..");
		object.getLocation();
		AppLogs.info("WEGetLocation ends..");
	}

	/***
	 * Purpose : It will return the width and height of the rendered WebElement.
	 * @param object
	 */
	public void WeGetSize(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getSize();
		AppLogs.info("WeElement ends..");
	}

	/***
	 * Purpose : It will give the visible text if the element contains any text on it or else will return
	 * nothing.
	 * @param object
	 */
	public void WeGetText(WebElement object) {
		AppLogs.info("WeGetText starts..");
		object.getText();
		AppLogs.info("WeGetText ends..");
	}

	/***
	 * Purpose : This will return the tag name of the WebElement. For example, in the following HTML
	 * code, button is the tag name of the HTML element
	 * @param object
	 */
	public void WeGetTagName(WebElement object) {
		AppLogs.info("WeGetTagName starts..");
		object.getTagName();
		AppLogs.info("WeGetTagName ends..");
	}

	/***
	 * Purpose : The verifies if an element is displayed on the web page and can be executed on all the WebElements.
	 * @param object
	 */
	public void iSElementDisplayed(WebElement object) {
		AppLogs.info("iSElementDisplayed starts..");
		object.isDisplayed();
		AppLogs.info("iSElementDisplayed ends..");
	}

	/***
	 * Purpose : TheisEnabled action verifies if an element is enabled on the web page and can be executed on all the WebElements.
	 * @param object
	 */
	public void iSElementEnabled(WebElement object) {
		AppLogs.info("iSElementEnabled starts..");
		object.isEnabled();
		AppLogs.info("iSElementEnabled ends..");
	}

	/***
	 * Purpose : Verifies if an element is selected right now on the web page and can be executed only on a radio button, options in select,
	 * and checkbox WebElements.
	 * @param object
	 */
	public void WeIsSelected(WebElement object) {
		AppLogs.info("WeIsSelected starts..");
		object.isSelected();
		AppLogs.info("WeIsSelected ends..");
	}

	// ################## Mouse Operation #################################
	/**
	 * Purpose : The moveByOffset() method is used to move the mouse from its current position to another point on the web page. User can specify the X
	 * distance and Y distance the mouse has to be moved. When the page is loaded, generally the initial position of a mouse would be (0, 0),
	 * @param object
	 * @param ToXPoint
	 * @param ToYPoint
	 */
	public void WeMouseOffset(WebElement object, int ToXPoint, int ToYPoint) {
		AppLogs.info("WeMouseOffset starts..");
		builder.moveByOffset(object.getLocation().getX() + ToXPoint, object.getLocation().getY() + ToYPoint);
		builder.perform();
		AppLogs.info("WeMouseOffset ends..");
	}

	/**
	 * Purpose : The click() method is used to simulate the left-click of your mouse at its current point of location. This method doesn't really realize where
	 * or on which element it is clicking. It just blindly clicks wherever it is at that point of time. Hence, this method is used in combination with
	 * some other action rather than independently, to create a composite action
	 * @param object
	 */
	public void WeMouseLeftClick(WebElement object) {
		AppLogs.info("WeMouseLeftClick starts..");
		builder.moveByOffset(object.getLocation().getX() + 1,object.getLocation().getY() + 1).click();
		builder.perform();
		AppLogs.info("WeMouseLeftClick ends..");
	}

	/**
	 * Purpose : The click() method is used to simulate the left-click of your mouse at its current point of location. This method doesn't really realize where
	 * or on which element it is clicking. It just blindly clicks wherever it is at that point of time. Hence, this method is used in combination with
	 * some other action rather than independently, to create a composite action
	 * @param object
	 * @param toXposition
	 * @param toYposition
	 */
	public void WeMouseLeftClick(WebElement object, int toXposition, int toYposition) {
		AppLogs.info("WeMouseLeftClick starts..");
		builder.moveByOffset(object.getLocation().getX() + toXposition,object.getLocation().getY() + toXposition).click();
		builder.perform();
		AppLogs.info("WeMouseLeftClick ends..");
	}
	
	/**
	 * Purpose : click() method to click directly on the WebElement.
	 * @param object
	 */
	public void ClickOnWebElement(WebElement object) {
		AppLogs.info("ClickOnWebElement starts..");
		builder.click(object);
		builder.build().perform();
		AppLogs.info("ClickOnWebElement ends..");
	}

	/***
	 * Purpose : The clickAndHold()method is another method of the Actions class that left-clicks on an element and holds it without releasing the left button
	 * of the mouse. This method will be useful when executing operations such as drag-and-drop.
	 * @param object
	 */
	public void ClickAndHold(WebElement object) {
		AppLogs.info("ClickAndHold starts..");
		builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).perform();
		AppLogs.info("ClickAndHold ends..");
	}

	
	/**
	 * Purpose : taken on a held WebElement is to release it so that the element can be dropped or released from the mouse.
	 * @param source
	 * @param target
	 */
	public void ClickAndHoldAndRelease(WebElement source, WebElement target) {
		AppLogs.info("ClickAndHoldAndRelease starts..");
		builder.clickAndHold(source).release(target).perform();
		AppLogs.info("ClickAndHoldAndRelease ends..");
	}

	/**
	 * Purpose : helps us to move the mouse cursor to a WebElement on the web page.
	 * @param object
	 */
	public void moveToElement(WebElement object) {
		AppLogs.info("moveToElement starts..");
		builder.moveToElement(object).clickAndHold().moveByOffset(120, 0).perform();
		AppLogs.info("moveToElement ends..");
	}

	/**
	 * Purpose :  have to drag-and-drop components or WebElements of a web page.
	 * @param object
	 */
	public void dragMe(WebElement object) {
		AppLogs.info("dragMe starts..");
		builder.dragAndDropBy(object, 300, 200).perform();
		AppLogs.info("dragMe ends..");
	}

	/**
	 * Purpose : The only difference being that instead of moving the WebElement by an offset, we move it on to a target element
	 * @param source
	 * @param target
	 */
	public void DragandDropToWE(WebElement source, WebElement target) {
		AppLogs.info("DragandDropToWE starts..");
		builder.dragAndDrop(source, target).perform();
		AppLogs.info("DragandDropToWE ends..");
	}

	/**
	 * Purpose : Moving on to another action that can be performed using mouse, doubleClick()is another out of the box method that WebDriver provides to
	 * emulate the double-clicking of the mouse.
	 * @param object
	 */
	public void DoubleClickOnWe(WebElement object) {
		AppLogs.info("DoubleClickOnWe starts..");
		builder.moveToElement(object).doubleClick().perform();
		AppLogs.info("DoubleClickOnWe ends..");
	}

	/**
	 * Purpose : The contextClick() method, also known as right-click, is quite common on many web pages these days. The context is nothing but a menu; a list of
	 * items is associated to a WebElement based on the current state of the web page.
	 * @param object
	 * @param item4
	 */
	public void RightClickOnWe(WebElement object, String item4) {
		AppLogs.info("RightClickOnWe starts..");
		builder.contextClick(object).click(driver.findElement(By.name("Item 4"))).perform();
		AppLogs.info("RightClickOnWe ends..");
	}
	
	/**
	 * 
	 * @param link
	 * @return
	 */
	
	
	/**
	 * Purpose : This method is useful when you have multiple links on a page and instead of click each link and verifying the page 
	 * title or what's written on the page - you can just send an http request to the link and see what the response is  
	 * @param link
	 * @return
	 * @throws MyException
	 */
	public boolean isFileDownloadable(String link) throws MyException{
		AppLogs.info("isFileDownloadable starts..");
		int code = 0;
		AppLogs.debug("Link: " + link);
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			code = connection.getResponseCode();
		} catch (Exception e) {
			AppLogs.error("isFileDownloadable ends.."+e);
			return false;
		}
		AppLogs.debug("code : " + code);
		AppLogs.info("isFileDownloadable ends..");
		return code == 200 || code == 302;
	}
		
	/**
	 * Purpose : This method switches to browser based on provided URL
	 * @param currentUrl
	 */
	public void SwitchToBrowser(String currentUrl) {
		AppLogs.info("ReadFromWebElement starts..");
		for(String winHandle :driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			if(driver.getCurrentUrl().equals(currentUrl)){
				System.out.println("You are in required window : " + driver.getCurrentUrl());
				AppLogs.debug("You are in required window : " + driver.getCurrentUrl());
				break;
            } 
			else{
				AppLogs.debug("URL of the page after - switchingTo: " + driver.getCurrentUrl());
			}
		}
	}
}