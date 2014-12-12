package com.framework.actions;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.framework.exception.SeleniumException;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

public interface Action {
	
	  
	    /**
	     * Wait for a javascript confirmation dialog to be present, then accept it.
	     */
	    public void acceptAlert(int timeout);

	    /**
	     * Wait for a javascript confirmation dialog to be present, then dismiss it.
	     */
	    public void dismissAlert(int timeout);

	    /**
	     * Click without polling for the element to be clickable or waiting until it's ready.
	     * Uses the implicit wait timeout built-in to Selenium.
	     *
	     * @throws JiveWebDriverException - if the element isn't clickable when this method is called.
	     */
	    public WebElement clickNoWait(By locator) throws SeleniumException;

	    /**
	     * Click the web element defined by the given CSS, with proper waiting until the element is clickable.
	     */
	    public WebElement click(By locator, int timeout);

	    /**
	     * Click the given web element, with proper waiting until the element is clickable.
	     */
	    public WebElement click(WebElement el, int timeout);


	    /**
	     * Click a web element, then verify another element is present on the DOM (not necessarily visible).
	     *
	     * @return - the WebElement we verified was present
	     */
	    public WebElement clickAndVerifyPresent(By locatorToClick, By locatorToVerifyPresent, int timeout);

	    public WebElement clickAndVerifyPresent(WebElement elToClick, By locatorToVerifyPresent, int timeout);

	    /**
	     * Click a web element, then verify another element is present on the DOM (not necessarily visible).
	     *
	     * @return - the WebElement we verified was present
	     */
	    public WebElement clickAndVerifyVisible(By locatorToClick, By locatorToVerifyPresent, int timeout);

	    public WebElement clickAndVerifyVisible(WebElement elToClick, By locatorToVerifyPresent, int timeout);

	    /**
	     * Click a web element, then verify another element is NOT present on the DOM (so also not visible).
	     */
	    public void clickAndVerifyNotPresent(By locatorToClick, By locatorToVerifyPresent, int timeout);

	    public void clickAndVerifyNotPresent(WebElement elToClick, By locatorToVerifyPresent, int timeout);

	    /**
	     * Click a web element, then verify another element is NOT present on the DOM (so also not visible).
	     */
	    public void clickAndVerifyNotVisible(By locatorToClick, By locatorToVerifyPresent, int timeout);

	    public void clickAndVerifyNotVisible(WebElement elToClick, By locatorToVerifyPresent, int timeout);

	    /**
	     * Click a web element defined by CSS cssToClick, then click a popup that is required to be displayed after clicking.
	     *
	     * @param locatorToClick - locator for the element to be clicked
	     * @param popoverLocator - locator for the popover element that must be present after clicking
	     */
	    public void clickAndSelectFromList(By locatorToClick, By popoverLocator);

	    public void clickAndSelectFromList(WebElement clickable, By popoverLocator);

	    /**
	     * Clear text from an input element.
	     *
	     * @param locator - locator defining the input element
	     * @return - the input element
	     */
	    public WebElement clearText(By locator);

	    public WebElement clearText(WebElement el);

	    /**
	     * Execute the given javascript synchronously and return the result.
	     *
	     * @return - see Selenium docs for what can be returned here, probably just Integer, Boolean, Double, or null
	     */
	    public Object executeJavascript(String script);

	    /**
	     * Wait for the given symbol to be defined AND non-null in javascript
	     */
	    public void waitForJavascriptSymbolToBeDefined(String symbol, int timeout);

	    public void waitForJavascriptSymbolToHaveValue(String symbol, String value, int timeout);

	    public String getWebPageReadyState() throws SeleniumException;

	    public void waitForWebPageReadyStateToBeComplete();

	    /**
	     * Immediately return true or false as to whether a web element exists on the page.
	     */
	    public boolean exists(By locator);

	    public boolean exists(By locator, WebElement parentEl);

	    public WebElement findElementWithRefresh(By locator, int timeout);

	    public WebElement findVisibleElementWithRefresh(By locator, int timeout);

	    /**
	     * Find the first element located by 'parentLocator' that has at least 1 child element located by the relative locator 'childLocator'
	     * @param parentLocator - locator to find parent elements
	     * @param childLocator - relative locator to find child elements inside a parent element
	     * @return - parent element that have at least 1 child element located by 'childLocator', or null if there are none.
	     */
	    public WebElement findElementContainingChild(final By parentLocator, final By childLocator);

	    /**
	     * Find elements located by 'parentLocator' that have child elements located by the relative locator 'childLocator'
	     * @param parentLocator - locator to find parent elements
	     * @param childLocator - relative locator to find child elements inside a parent element
	     * @return - parent elements that have at least 1 child element located by 'childLocator'
	     */
	    public List<WebElement> findElementsContainingChild(final By parentLocator, final By childLocator);

	    /**
	     * Search for a WebElement located by 'locator' that has a child element located in its sub-tree
	     * located by 'childLocator'.
	     *
	     * Poll repeatedly until a timeout occurs, but do not refresh the page.
	     *
	     * @param parentLocator - parent locator
	     * @param childLocator - a locator relative to the parent to find the child element
	     *
	     * @return - the parent element located by the 'locator' param
	     */
	    public WebElement findElementContainingChildWithWait(final By parentLocator, final By childLocator, int timeout);

	    public List<WebElement> findElementsContainingChildWithWait(final By parentLocator, final By childLocator, int timeout);

	    public WebElement findElementContainingText(By locator, String text);

	    public WebElement findVisibleElementContainingText(By locator, String text);

	    public WebElement findVisibleElementContainingTextWithWait(final By locator, final String text, int timeout);

	    public WebElement findElementContainingTextWithRefresh(final By locator, final String text, int timeout);

	    public WebElement findVisibleElementContainingTextWithRefresh(final By locator, final String text, int timeout);

	    public WebElement findElementContainingTextWithWait(By locator, String text, int timeout);

	    /**
	     * Immediately try to return a WebElement without any implicit or explicit waiting.
	     *
	     * @return - the WebElement, or null if not present.
	     */
	    public
	    @Nullable
	    WebElement getElement(By locator);

	    public
	    @Nullable
	    WebElement getChildElement(By locator, WebElement parentEl);

	    /**
	     * Get a WebElement using the implicit wait configured for the Selenium WebDriver.
	     *
	     * @return the WebElement when found. Null is never returned.
	     * @throws RuntimeException - if the web element isn't present after waiting.
	     */
	    public
	    @Nonnull
	    WebElement getElementWithWait(By locator);

	    public
	    @Nonnull
	    WebElement getChildElementWithWait(By locator, WebElement parentEl);

	    public List<WebElement> getElements(By locator);

	    public List<WebElement> getChildElements(By locator, WebElement parentEl);

	    public WebElement getParentElement(WebElement el);

	    public WebElement inputText(By locator, String text);

	    public WebElement inputText(@Nonnull WebElement el, String text);

	    public WebElement inputTextAndSelectFromList(WebElement inputField, String value, By popoverLocator) throws SeleniumException;

	    public WebElement inputTextAndSelectFromList(WebElement inputField, String value, By popoverLocator, int withRetryCount) throws SeleniumException;

	    public WebElement inputTextSlowly(By locator, String text);

	    public WebElement inputTextSlowly(WebElement el, String text);

	    public WebElement inputTextSlowlyAndSelectFromList(WebElement inputField, String value, By popoverLocator) throws SeleniumException;

	    public WebElement inputTextSlowlyAndSelectFromList(WebElement inputField, String value, By popoverLocator, int withRetryCount) throws SeleniumException;

	    /**
	     * Enter the given text into the input defined by inputCSS, one character at a time.
	     * At each step, verify the previous popup was removed from the DOM, and find the new popup.
	     * Then see if there is a popup containing the required text on the page. If so, click it and return.
	     *
	     * @param inputLocator          - locator for the input element
	     * @param text              - text you are entering into the input element
	     * @param popoverLocator      - locator for the popup element containing required text, or list element if there multiple
	     * @param requiredPopupText - text required to be present in popup element defined by popupItemCss
	     */
	    public void enterTextForAutoCompleteAndSelectFirstMatch(By inputLocator, String text, By popoverLocator,
	                                                            String requiredPopupText);

	    /**
	     * Same as above, but enter minChars characters before checking for the popup to exist.
	     *
	     * @param minChars
	     */
	    public void enterTextForAutoCompleteAndSelectFirstMatch(By inputLocator, int minChars, String text, By popoverLocator,
	                                                            String requiredPopupText);


	    /**
	     * Enter text into the active tiny MCE editor.
	     */
	    public void inputTinyMceText(String text);

	    /**
	     * Wait for tinyMCE.activeEditor.initialized to be true, see Tiny MCE documentation online for why.
	     */
	    public void waitForTinyMceToBeReady();

	    /**
	     * Return immediately with an answer as to whether an element is clickable.
	     *
	     * @return - true if the element is present and clickable, false otherwise.
	     */
	    public boolean isClickable(By locator);

	    public boolean isClickable(WebElement el);

	    /**
	     * Return immediately with an answer as to whether an element is visible.
	     *
	     * @return - true if the element is present and visible, false otherwise.
	     * See Selenium's docs for the definition of visible, it has to be on the page, scrolled into view,
	     * have a height and width > 0, etc.
	     */
	    public boolean isVisible(By locator);

	    public boolean isVisible(WebElement css);

	    /**
	     * Scroll so that the element is in the middle of the page.
	     */
	    public void scrollIntoView(By locator);

	    public void scrollIntoView(WebElement el);

	    /**
	     * Scroll the given element with a scroll bar defined by parentCSS so that the web element given by css is in view
	     */
	    public void scrollIntoView(By scrollContainerLocator, By locator);

	    public void scrollIntoView(By scrollContainerLocator, WebElement el);

	    /**
	     * Returns a Page object with initialized WebElements that is a valid page class for the currently open page in the web driver.
	     *
	     * @param pageClass - a Class representing the type of page to be initialized.
	     */
	    public void verifyElementContainsText(By locator, String text, int timeout);

	    public void verifyElementSelected(By locator, int timeout);

	    public void verifyElementSelected(WebElement el, int timeout);

	    public void verifyElementNotSelected(By locator, int timeout);

	    public void verifyElementNotSelected(WebElement el, int timeout);

	    public WebElement verifyElementPresented(By locator, int timeout);

	    public void verifyElementNotPresented(By locator, int timeout);

	    public void verifyElementWithTextNotPresented(By locator, String text, int timeout);

	    public WebElement verifyElementVisible(By locator, int timeout);

	    public void verifyElementInvisible(By locator, int timeout);

	    public void verifyElementWithTextIsInvisible(By locator, String text, int timeout);

	    /* Method to simplify general waiting code in Pages and Keywords. Takes a function and waits until the return value is non-null.*/
	    public <T, V> V waitOnFunction(Function<T, V> function, T input, String message, int timeout);

	    /* Method to simplify general waiting code in Pages and Keywords. Takes a predicate and waits until it returns true.*/
	    public <T> void waitOnPredicate(Predicate<T> predicate, T input, String message, int timeout);

	    /* Same, but a helper for predicates that don't require an Input, because they use closure to interact with a containing class. */
	    public void waitOnPredicate(Predicate<Object> predicate, String message, int timeout);

	    /* Same, but refresh the page after each time the predicate is checked. */
	    public <T> void waitOnPredicateWithRefresh(Predicate<T> predicate, T input, String message, int timeout);

	    /* Same, but no input is required. */
	    public void waitOnPredicateWithRefresh(Predicate<Object> predicate, String message, int timeout);

	    public <T> T waitOnExpectedCondition(ExpectedCondition<T> expectedCondition, String message, int timeout);

	    /**
	     * Verify the given WebElement becomes stale (removed from the DOM).
	     * @param element - element we expect to be removed from the DOM
	     * @param timeout - timeout type, defaults to the webElementPresenceTimeout (typically 5 seconds).
	     */
	    public void verifyElementRemoved(WebElement element, int timeout);

	    public WebElement verifyPageRefreshed(WebElement elementFromBeforeRefresh, By locatorAfterRefresh, int timeout);

	    public WebElement waitUntilClickable(By locator, int timeout);

	    public WebElement waitUntilClickable(WebElement el, int timeout);

	    /**
	     * @return true if-and-only-if the web element found by the given locator has the CSS class "cssClass"
	     */
	    public boolean doesElementHaveClass(By locator, String locatorClass);

	    public WebElement verifyElementHasClass(By locator, String locatorClass, int timeout);

	    public WebElement verifyElementDoesNotHaveClass(final By locator, final String locatorClass, int timeout);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void verifyElementNotPresented(By locator, long timeout);

}