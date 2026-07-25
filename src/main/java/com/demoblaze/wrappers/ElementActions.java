package com.demoblaze.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.demoblaze.utilities.WaitUtils;

/**
 * ElementActions
 *
 * Reusable Selenium element actions with explicit waits.
 *
 * @author Gopi Kishan Behera
 */
public class ElementActions {

    private final WaitUtils waitUtils;

    public ElementActions() {
        waitUtils = new WaitUtils();
    }

    /**
     * Click on element.
     */
    public void click(By locator) {

        waitUtils.waitForElementToBeClickable(locator).click();

    }

    /**
     * Enter text.
     */
    public void type(By locator, String text) {

        WebElement element = waitUtils.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);

    }

    /**
     * Get visible text.
     */
    public String getText(By locator) {

        return waitUtils.waitForVisibility(locator).getText();

    }

    /**
     * Check element visibility.
     */
    public boolean isDisplayed(By locator) {

        return waitUtils.waitForVisibility(locator).isDisplayed();

    }

    /**
     * Get attribute value.
     */
    public String getAttribute(By locator, String attribute) {

        return waitUtils.waitForVisibility(locator)
                .getAttribute(attribute);

    }

    /**
     * Get WebElement.
     */
    public WebElement getElement(By locator) {

        return waitUtils.waitForVisibility(locator);

    }

}