package com.framework.actions;

import javax.annotation.Nonnull;

import org.openqa.selenium.WebElement;

public interface IAction {
	public WebElement inputTextSlowly(@Nonnull WebElement el, String text);
	public void verifyElementRemoved(WebElement element, int timeout);

}
