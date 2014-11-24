package com.framework.actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.framework.exception.MyException;
import com.framework.report.DetailedLogs;

/**
 * WebAction.java is for interacting with browser objects. Page objects re-use these utilities to perform functions relevant to test steps. 
 * 
 * @author : Abhay Bharti
 * @version 1.0 21/09/14
 */
public abstract class WebAction implements IAction {
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
		AppLogs.info("ReadFromWebElement starts.. "+ "1st Arg : "+object.getText() + "2nd Arg : "+ attribute);
		object.getAttribute(attribute);
		AppLogs.info("ReadFromWebElement ends..");
	}

	/**
	 * Purpose : This method enters text in Input box
	 * @param object
	 * @param input
	 */
	public void EnterValueText(WebElement object,String input) {
		AppLogs.info("EnterValueText starts.."+ "1st Arg : "+object.getTagName() + "2nd Arg : "+ input);
		object.clear();
		object.sendKeys(input);
		AppLogs.info("EnterValueText ends..");
	}

	/**
	 * Purpose : Parameterized version, This method Type special key like Shift,Backspace, Enter, Tab, Shift along with text
	 * @param object
	 * @param input
	 */
	public void EnterValueText(WebElement object,Keys theKey, String input) throws MyException{
		AppLogs.info("EnterValueTextWithShit starts.." + "1st Arg : "+object.getTagName() + "2nd Arg : "+ input);
		 try{
			 object.sendKeys(Keys.chord(Keys.SHIFT,input));
		 }catch(IllegalArgumentException e){
			 throw new MyException("WebAction -> EnterValueText(WebElement object,Keys theKey, String input)" + e);
		 }
			 AppLogs.info("EnterValueTextWithShit ends..");
	}
	
	/**
	 * Purpose : This is used to fetch the CSS properties' values of the given element. CSS properties
	 * can be font-family, background-color, color, and so on.
	 * @param object
	 * @param ProprertyName
	 */
	public void ReadCSSFromWebElement(WebElement object, String ProprertyName) {
		AppLogs.info("ReadCSSFromWebElement starts.."+ "1st Arg : "+object.getTagName() + "2nd Arg : "+ ProprertyName);
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
		AppLogs.info("WEGetLocation starts.."+ "1st Arg : "+object.getTagName());
		object.getLocation();
		AppLogs.info("WEGetLocation ends..");
	}

	/***
	 * Purpose : It will return the width and height of the rendered WebElement.
	 * @param object
	 */
	public void WeGetSize(WebElement object) {
		AppLogs.info("ReadFromWebElement starts.."+ "1st Arg : "+object.getTagName());
		object.getSize();
		AppLogs.info("WeElement ends..");
	}

	/***
	 * Purpose : It will give the visible text if the element contains any text on it or else will return
	 * nothing.
	 * @param object
	 */
	public void WeGetText(WebElement object) {
		AppLogs.info("WeGetText starts.."+ "1st Arg : "+object.getTagName());
		object.getText();
		AppLogs.info("WeGetText ends..");
	}

	/***
	 * Purpose : This will return the tag name of the WebElement. For example, in the following HTML
	 * code, button is the tag name of the HTML element
	 * @param object
	 */
	public void WeGetTagName(WebElement object) {
		AppLogs.info("WeGetTagName starts.."+ "1st Arg : "+object.getTagName() );
		object.getTagName();
		AppLogs.info("WeGetTagName ends..");
	}

	/***
	 * Purpose : The verifies if an element is displayed on the web page and can be executed on all the WebElements.
	 * @param object
	 */
	public void iSElementDisplayed(WebElement object) {
		AppLogs.info("iSElementDisplayed starts.."+ "1st Arg : "+object.getTagName());
		object.isDisplayed();
		AppLogs.info("iSElementDisplayed ends..");
	}

	/***
	 * Purpose : TheisEnabled action verifies if an element is enabled on the web page and can be executed on all the WebElements.
	 * @param object
	 */
	public void iSElementEnabled(WebElement object) {
		AppLogs.info("iSElementEnabled starts.."+ "1st Arg : "+object.getTagName());
		object.isEnabled();
		AppLogs.info("iSElementEnabled ends..");
	}

	/***
	 * Purpose : Verifies if an element is selected right now on the web page and can be executed only on a radio button, options in select,
	 * and checkbox WebElements.
	 * @param object
	 */
	public void WeIsSelected(WebElement object) {
		AppLogs.info("WeIsSelected starts.."+ "1st Arg : "+object.getTagName());
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
		AppLogs.info("WeMouseOffset starts.."+ "1st Arg : "+object.getTagName() + "2nd Arg : "+ToXPoint+ "3rd Arg : "+ToYPoint);
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
		AppLogs.info("WeMouseLeftClick starts.."+ "1st Arg : "+object.getTagName());
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
		AppLogs.info("WeMouseLeftClick starts.."+ "1st Arg : "+object.getTagName() + "2nd Arg : "+toXposition+ "3rd Arg : "+toYposition);
		builder.moveByOffset(object.getLocation().getX() + toXposition,object.getLocation().getY() + toXposition).click();
		builder.perform();
		AppLogs.info("WeMouseLeftClick ends..");
	}
	
	/**
	 * Purpose : click() method to click directly on the WebElement.
	 * @param object
	 */
	public void ClickOnWebElement(WebElement object) {
		AppLogs.info("ClickOnWebElement starts.."+ "1st Arg : "+object.getTagName());
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
		AppLogs.info("ClickAndHold starts.."+ "1st Arg : "+object.getTagName());
		builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).perform();
		AppLogs.info("ClickAndHold ends..");
	}

	
	/**
	 * Purpose : taken on a held WebElement is to release it so that the element can be dropped or released from the mouse.
	 * @param source
	 * @param target
	 */
	public void ClickAndHoldAndRelease(WebElement source, WebElement target) {
		AppLogs.info("ClickAndHoldAndRelease starts.."+ "1st Arg : "+source.getTagName()+ " 2nd Arg : "+target.getTagName());
		builder.clickAndHold(source).release(target).perform();
		AppLogs.info("ClickAndHoldAndRelease ends..");
	}

	/**
	 * Purpose : helps us to move the mouse cursor to a WebElement on the web page.
	 * @param object
	 */
	public void moveToElement(WebElement object) {
		AppLogs.info("moveToElement starts.." +"1st Arg : "+object.getTagName());
		builder.moveToElement(object).clickAndHold().moveByOffset(120, 0).perform();
		AppLogs.info("moveToElement ends..");
	}

	/**
	 * Purpose :  have to drag-and-drop components or WebElements of a web page.
	 * @param object
	 */
	public void dragMe(WebElement object) {
		AppLogs.info("dragMe starts.."+"1st Arg : "+object.getTagName());
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
		AppLogs.info("DoubleClickOnWe starts.."+"1st Arg : "+object.getTagName());
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
		AppLogs.info("RightClickOnWe starts.."+"1st Arg : "+object.getTagName());
		builder.contextClick(object).click(driver.findElement(By.name("Item 4"))).perform();
		AppLogs.info("RightClickOnWe ends..");
	}
	
	
	/**
	 * Purpose : returns HTTP code for a given URL
	 * @param urlString
	 * @return
	 */
	public boolean getResponseCode(String urlString) throws MyException{
		AppLogs.info("getResponseCode starts.. for URL : "+urlString);
	    boolean isValid = false;
	    int code = 0;
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
            httpURLConnect.setRequestMethod("GET");
            httpURLConnect.connect();
            code = httpURLConnect.getResponseCode();
            if (code == 200){
            	AppLogs.debug(urlString +" - "+httpURLConnect.getResponseMessage());
            	isValid = true;
            }
            if(code == HttpURLConnection.HTTP_NOT_FOUND)  
            {
            	AppLogs.debug(urlString +" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            	isValid = true;
            }
         } catch (MalformedURLException e) {
            throw new MyException("MalformedURLException Error : "+e +" , "+ urlString);
         } catch (IOException e) {
        	  throw new MyException("IOException Error : "+e+" , "+ urlString);
         } catch (Exception e) {
        	  throw new MyException("Exception Error : "+e+" , "+ urlString);
         }
        AppLogs.info("getResponseCode ends..");
        return isValid;
    }
	
	/**
	 * Purpose : This method is useful when you have multiple links on a page and instead of click each link and verifying the page 
	 * title or what's written on the page - you can just send an http request to the link and see what the response is  
	 * @param link
	 * @return
	 * @throws MyException
	 */
	public boolean isFileDownloadable(String link) throws MyException{
		AppLogs.info("isFileDownloadable starts.. for URL : "+link);
		boolean isValid = false;
		AppLogs.debug("Link: " + link);
		try {
			if (getResponseCode(link)){
				isValid = true;
			}
		} catch (Exception e) {
			throw new MyException("isFileDownloadable ends.."+e);
		}
		AppLogs.info("isFileDownloadable ends..");
		return isValid;
	}
		
	

	/**
	 * Purpose : Verifies if link on a given page is broken
	 * @throws MyException
	 */
	public String isLinkBroken() throws MyException{
	   AppLogs.info("isLinkBroken starts.. for URL : "+driver.getCurrentUrl());
	   String link = null;
       List <WebElement>linksList = driver.findElements(By.tagName("a")); 
        for(WebElement linkElement: linksList){
          link =linkElement.getAttribute("href");
          if(link!=null){
            if (getResponseCode(link)){
            	Reporter.log("isLinkBroken : "+link + "  works fine");
            }else {
            	Reporter.log("isLinkBroken : "+link + "  works fine");
            }
          }
      }
        AppLogs.info("isLinkBroken starts.. for URL : "+driver.getCurrentUrl());
      return link;
  } 
  
	/**
	 * Purpose : Parameterize form of isLinkBroken method, verifies if link on a given page is broken
	 * @throws MyException
	 */
	public boolean isLinkBroken(String urlString) throws MyException{
	   AppLogs.info("isLinkBroken starts .. for URL : "+ urlString);
	    boolean isValid = false;
	      if(urlString!=null){
            if (getResponseCode(urlString)){
            	isValid = true;
            }else {
            	isValid = false;
            }
          }
	    AppLogs.info("isLinkBroken ends .. for URL : "+ urlString);
      return isValid;
  } 
	
	//---------------------Working on Multiple Browser/Switching Frame/Handling Alert-------------------------
	/**
	 * Purpose : This method switches to browser based on browser URL
	 * @param currentUrl
	 */
	public void SwitchToBrowser(String currentUrl) {
		AppLogs.info("ReadFromWebElement starts.. for URL : "+currentUrl);
		for(String winHandle :driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			if(driver.getCurrentUrl().equals(currentUrl)){
				AppLogs.info("You are in required window : " + driver.getCurrentUrl());
				break;
            } 
			else{
				AppLogs.error("URL of the page after - switchingTo: " + driver.getCurrentUrl());
			}
		}
	}
	
	/**
	 * Purpose : switch target to a Frame of a browser
	 * @param frameIndex
	 */
	public void SwitchToFrame(String frameIndex){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);      
	}      
	
	/**
	 * Purpose : switch target to a second Frame of a browser where target is set to first frame
	 * @param frameIndex
	 */
	public void SwitchToFrame(String frameIndex1,String frameIndex2){
		driver.switchTo().frame(frameIndex1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameIndex2);      
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean AcceptAlert() throws MyException {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		}catch(NoAlertPresentException e){
			throw new MyException("WebAction -> AcceptAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> AcceptAlert() , "+e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean DeclineAlert() throws MyException {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			return true;
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public boolean SetTextOnAlert(String keysToSend) throws MyException {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(keysToSend);
			return true;
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public String GetTextOfAlert() throws MyException {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public void BrowserRefresh() throws MyException {
		try {
			driver.navigate().refresh();
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public void BrowserForward() throws MyException {
		try {
			driver.navigate().forward();
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public void BrowserBack() throws MyException {
		try {
			driver.navigate().back();
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws MyException
	 */
	public boolean OpenURL(String URL) throws MyException {
		boolean isValid = false;
		try {
			driver.navigate().to(URL);
			if (getResponseCode(URL)){
				AppLogs.info(URL + " successfully opened");
				isValid = true;
			}else {
				AppLogs.info(URL + " not working");
				isValid = false;
			}
		} catch(NoAlertPresentException e){
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		catch (Exception e) {
			throw new MyException("WebAction -> DeclineAlert() , "+e);
		}
		return isValid;
	}
	
	/**
	 * Purpose : Download a file
	 */
	/**
	Load the page
	Get the URL of the first download link
	Perform a GET action against the URL with an HTTP library
	Store the response
	Assert that the file type is correct
	Assert that the file is not empty
	*/
	
	
	/**
	 * Purpose : Upload a file
	 */
	/**
	 * Load the page
		Find the form element that stores the path of the file we want to upload
		Inject the path of the file we want to upload
		Find the form submit button and click it
		Grab the text from the uploaded file list that gets rendered
		Assert that the uploaded file is what we expect
	 */
	
	/**
	 * 
	 */
	/**
	 * Find all images on the page
Iterate through each image, finding a match for the src attribute with a 404 status code
Store the broken images in a collection
Assert that the broken images collection is empty
	 */
	
	//==============Page Synchronization Methods===============
	public void waitForElementPresent(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public boolean isElementPresent(String xpath) {
		return driver.findElements(By.xpath(xpath)).size() > 0;
	}
	
	public boolean isElementPresent(By by) {
		return driver.findElements(by).size() > 0;
	}
}
