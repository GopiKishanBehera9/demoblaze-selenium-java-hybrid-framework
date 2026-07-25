package com.demoblaze.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.demoblaze.driver.DriverManager;

/**
 * ElementActions
 *
 * Common reusable Selenium actions.
 * All Page Objects should use this class instead of directly using WebDriver.
 *
 * @author Gopi Kishan Behera
 */
public class ElementActions {

    private final WaitUtils waitUtils = new WaitUtils();

    // ==========================
    // Basic Actions
    // ==========================

    /**
     * Click on element.
     *
     * @param locator element locator
     */
    public void click(By locator) {

        waitUtils.waitForElementToBeClickable(locator)
                 .click();

    }

    /**
     * Type text into textbox.
     *
     * @param locator element locator
     * @param text input text
     */
    public void type(By locator, String text) {

        WebElement element = waitUtils.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);

    }

    /**
     * Clear textbox.
     *
     * @param locator element locator
     */
    public void clear(By locator) {

        waitUtils.waitForVisibility(locator)
                 .clear();

    }

    /**
     * Get visible text.
     *
     * @param locator element locator
     * @return element text
     */
    public String getText(By locator) {

        return waitUtils.waitForVisibility(locator)
                        .getText();

    }

    /**
     * Check whether element is displayed.
     *
     * @param locator element locator
     * @return true if displayed
     */
    public boolean isDisplayed(By locator) {

        return waitUtils.waitForVisibility(locator)
                        .isDisplayed();

    }

    /**
     * Check whether element is enabled.
     *
     * @param locator element locator
     * @return true if enabled
     */
    public boolean isEnabled(By locator) {

        return waitUtils.waitForVisibility(locator)
                        .isEnabled();

    }

    /**
     * Check whether element is selected.
     *
     * @param locator element locator
     * @return true if selected
     */
    public boolean isSelected(By locator) {

        return waitUtils.waitForVisibility(locator)
                        .isSelected();

    }

    /**
     * Get attribute value.
     *
     * @param locator element locator
     * @param attribute attribute name
     * @return attribute value
     */
    public String getAttribute(By locator, String attribute) {

        return waitUtils.waitForVisibility(locator)
                        .getAttribute(attribute);

    }

    // ==========================
    // Dropdown Methods
    // ==========================

    /**
     * Select dropdown option by visible text.
     *
     * @param locator dropdown locator
     * @param text visible text
     */
    public void selectByVisibleText(By locator, String text) {

        Select select = new Select(
                waitUtils.waitForVisibility(locator));

        select.selectByVisibleText(text);

    }

    /**
     * Select dropdown option by value.
     *
     * @param locator dropdown locator
     * @param value option value
     */
    public void selectByValue(By locator, String value) {

        Select select = new Select(
                waitUtils.waitForVisibility(locator));

        select.selectByValue(value);

    }

    /**
     * Select dropdown option by index.
     *
     * @param locator dropdown locator
     * @param index option index
     */
    public void selectByIndex(By locator, int index) {

        Select select = new Select(
                waitUtils.waitForVisibility(locator));

        select.selectByIndex(index);

    }

    // ==========================
    // Mouse Actions
    // ==========================

    /**
     * Hover mouse over an element.
     *
     * @param locator element locator
     */
    public void hover(By locator) {

        WebElement element = waitUtils.waitForVisibility(locator);

        Actions actions = new Actions(DriverManager.getDriver());

        actions.moveToElement(element).perform();

    }

    /**
     * Double click on an element.
     *
     * @param locator element locator
     */
    public void doubleClick(By locator) {

        WebElement element = waitUtils.waitForVisibility(locator);

        Actions actions = new Actions(DriverManager.getDriver());

        actions.doubleClick(element).perform();

    }

    /**
     * Right click on an element.
     *
     * @param locator element locator
     */
    public void rightClick(By locator) {

        WebElement element = waitUtils.waitForVisibility(locator);

        Actions actions = new Actions(DriverManager.getDriver());

        actions.contextClick(element).perform();

    }

    /**
     * Drag source element and drop it on target element.
     *
     * @param source source locator
     * @param target target locator
     */
    public void dragAndDrop(By source, By target) {

        WebElement sourceElement =
                waitUtils.waitForVisibility(source);

        WebElement targetElement =
                waitUtils.waitForVisibility(target);

        Actions actions = new Actions(DriverManager.getDriver());

        actions.dragAndDrop(sourceElement, targetElement)
               .perform();

    }

}