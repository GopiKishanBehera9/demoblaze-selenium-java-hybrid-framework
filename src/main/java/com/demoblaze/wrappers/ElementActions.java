package com.demoblaze.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.demoblaze.driver.DriverManager;

/**
 * ElementActions
 *
 * Common reusable Selenium actions.
 *
 * @author Gopi Kishan Behera
 */
public class ElementActions {

    /**
     * Click on element.
     *
     * @param locator By locator
     */
    public void click(By locator) {
        DriverManager.getDriver().findElement(locator).click();
    }

    /**
     * Type text.
     *
     * @param locator By locator
     * @param text Text to enter
     */
    public void type(By locator, String text) {

        WebElement element = DriverManager.getDriver().findElement(locator);

        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get visible text.
     *
     * @param locator By locator
     * @return element text
     */
    public String getText(By locator) {
        return DriverManager.getDriver().findElement(locator).getText();
    }

    /**
     * Check element display.
     *
     * @param locator By locator
     * @return true if displayed
     */
    public boolean isDisplayed(By locator) {
        return DriverManager.getDriver().findElement(locator).isDisplayed();
    }

    /**
     * Get attribute value.
     *
     * @param locator By locator
     * @param attribute attribute name
     * @return attribute value
     */
    public String getAttribute(By locator, String attribute) {
        return DriverManager.getDriver()
                .findElement(locator)
                .getAttribute(attribute);
    }

}