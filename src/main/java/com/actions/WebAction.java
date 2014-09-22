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
 * The utility class for interacting with forms. Page objects re-use these utilities to perform functions relevant to Moodle. 
 * @author Tim Barker 
 * @see <a href="http://www.gnu.org/copyleft/gpl.html">License: GNU GPL v3 or later</a>
 */

/**
 * Constructor for the FormActions utility class.	
 * @param driver The driver that is used for the test. There is no need to specify the value for the driver here as the driver
 * is instantiated in the page object using one of the com.moodle.seleniumutils.SeleniumManager constructors.
 */

/**
 * TestBase.java Purpose: This class contains action methods to be used in page
 * object class
 * 
 * @author : Abhay Bharti
 * @version 1.0 21/05/14
 */
public abstract class WebAction {
	protected WebDriver driver = null;
	protected DetailedLogs AppLogs = null;
	final int waitvalue = 10;
	Actions builder = null;
	
	public WebAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		builder = new Actions(this.driver);
		AppLogs = new DetailedLogs();
	}


	// how we can get all the attributes of a WebElement using WebDriver.
	public void ReadFromWebElement(WebElement object, String attribute) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getAttribute(attribute);
		AppLogs.info("ReadFromWebElement ends..");
	}

	// Type special key like Shift,Backspace, Enter, Tab, Shift,
	public void EnterValueText(WebElement object,String input) {
		AppLogs.info("EnterValueText starts..");
		object.sendKeys(Keys.chord(Keys.SHIFT,input));
		AppLogs.info("EnterValueText ends..");
	}

	/**
	 * The getCssValue action can be taken on all the WebElements. This is used
	 * to fetch the CSS properties' values of the given element. CSS properties
	 * can be font-family, background-color, color, and so on.
	 */
	public void ReadCSSFromWebElement(WebElement object, String ProprertyName) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getCssValue(ProprertyName);
		// getCssValue("font-family"));
		// getCssValue("background-color"));
	}

	/***
	 * The getLocation action can be executed on all the WebElements. This is
	 * used to get the relative position of an element where it is rendered on
	 * the web page.
	 * 
	 * The preceding method obviously doesn't take any input parameter, but the
	 * return type is a Point class, which contains the (x, y) coordinates of
	 * the element.
	 */
	public void WebElementGetLocation(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getLocation();
	}

	/***
	 * The getSize action can also be applied on all the visible components of
	 * HTML. It will return the width and height of the rendered WebElement.
	 */
	public void WebElementGetSize(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getSize();
	}

	/***
	 * The getText action can be taken on all the WebElements. It will give the
	 * visible text if the element contains any text on it or else will return
	 * nothing.
	 */
	public void WebElementGetText(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getText();
	}

	/***
	 * The getTagName action can be taken on all the WebElements. This will
	 * return the tag name of the WebElement. For example, in the following HTML
	 * code, button is the tag name of the HTML element
	 */
	public void WebElementGetTagName(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.getTagName();
	}

	/***
	 * The isDisplayed action verifies if an element is displayed on the web
	 * page and can be executed on all the WebElements.
	 */
	public void WebElementIsDisplayed(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.isDisplayed();
	}

	/***
	 * TheisEnabled action verifies if an element is enabled on the web page and
	 * can be executed on all the WebElements.
	 */
	public void WebElementEnabled(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.isEnabled();
	}

	/***
	 * The isSelected action verifies if an element is selected right now on the
	 * web page and can be executed only on a radio button, options in select,
	 * and checkbox WebElements.
	 */
	public void WebElementIsSelected(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		object.isSelected();
	}

	// ################## Mouse Operation #################################
	/***
	 * The moveByOffset() method is used to move the mouse from its current
	 * position to another point on the web page. User can specify the X
	 * distance and Y distance the mouse has to be moved. When the page is
	 * loaded, generally the initial position of a mouse would be (0, 0),
	 */
	public void WebElementMouseOffset(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.moveByOffset(object.getLocation().getX() + 1, object.getLocation().getY() + 1);
		builder.perform();
	}

	/***
	 * The click() method is used to simulate the left-click of your mouse at
	 * its current point of location. This method doesn't really realize where
	 * or on which element it is clicking. It just blindly clicks wherever it is
	 * at that point of time. Hence, this method is used in combination with
	 * some other action rather than independently, to create a composite action
	 */
	public void MouseLeftClick(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.moveByOffset(object.getLocation().getX() + 1,object.getLocation().getY() + 1).click();
		builder.perform();
	}

	/***
	 * when the WebElement has its own identifiers, such as a name or ID. We can
	 * use another overloaded version of the click() method to click directly on
	 * the WebElement.
	 */
	public void ClickOnWebElement(WebElement object) {
		AppLogs.info("ClickOnWebElement starts..");
		// Click on One
		//builder.click(element).click(element).click(element);
		//builder.build().perform();
		object.click();
		AppLogs.info("ClickOnWebElement ends..");
	}

	/***
	 * The clickAndHold()method is another method of the Actions class that
	 * left-clicks on an element and holds it without releasing the left button
	 * of the mouse. This method will be useful when executing operations such
	 * as drag-and-drop.
	 */
	public void ClickAndHold(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).perform();
	}

	/***
	 * overloaded method of the clickAndHold() method that takes the WebElement
	 * as inpu
	 */
	public void ClickAndHoldOnWebElement(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		// Move tile3 to the position of tile2
		builder.clickAndHold(object).moveByOffset(120, 0).perform();
	}

	/***
	 * taken on a held WebElement is to release it so that the element can be
	 * dropped or released from the mouse.
	 */
	public void ClickAndHoldAndRelease(WebElement source, WebElement target) {
		AppLogs.info("ReadFromWebElement starts..");
		// Move tile3 to the position of tile2
		builder.clickAndHold(source).release(target).perform();
	}

	/***
	 * that helps us to move the mouse cursor to a WebElement on the web page.
	 */
	public void moveToElement(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		// Move tile3 to the position of tile2
		builder.moveToElement(object).clickAndHold().moveByOffset(120, 0).perform();
	}

	/***
	 * have to drag-and-drop components or WebElements of a web page.
	 */
	public void dragMe(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.dragAndDropBy(object, 300, 200).perform();
	}

	/***
	 * The only difference being that instead of moving the WebElement by an
	 * offset, we move it on to a target element
	 */
	public void DragandDropToWE(WebElement source, WebElement target) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.dragAndDrop(source, target).perform();
	}

	/***
	 * Moving on to another action that can be performed using mouse,
	 * doubleClick()is another out of the box method that WebDriver provides to
	 * emulate the double-clicking of the mouse.
	 */
	public void DoubleClickOnWebElement(WebElement object) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.moveToElement(object).doubleClick().perform();
	}

	/***
	 * The contextClick() method, also known as right-click, is quite common on
	 * many web pages these days. The context is nothing but a menu; a list of
	 * items is associated to a WebElement based on the current state of the web
	 * page.
	 */
	public void RightClickOnWebElement(WebElement object, String item4) {
		AppLogs.info("ReadFromWebElement starts..");
		builder.contextClick(object).click(driver.findElement(By.name("Item 4"))).perform();
	}
	
	/**
	 * 
	 * @param link
	 * @return
	 */
	
	// this method is useful when you have multiple links on a page and instead
		// of click each link
		// and verifying the page title or what's written on the page - you can just
		// send an http request
		// to the link and see what the response is
		public boolean isFileDownloadable(String link) throws MyException{
			AppLogs.info("isFileDownloadable starts..");
			int code = 0;
			AppLogs.debug("Link: " + link);
			try {
				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
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