package com.demoblaze.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.demoblaze.driver.DriverManager;
import com.demoblaze.exceptions.ElementActionException;

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

        try {

            DriverManager.getDriver()
                    .findElement(locator)
                    .click();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to click element : " + locator,
                    e);

        }

    }

    /**
     * Type text into textbox.
     * @param locator element locator
     * @param text input text
     */
    public void type(By locator, String text) {

        try {

            WebElement element =
                    DriverManager.getDriver().findElement(locator);

            element.clear();
            element.sendKeys(text);

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to type into element : " + locator,
                    e);

        }

    }

    /**
     * Clear textbox.
     *
     * @param locator element locator
     */
    public void clear(By locator) {

        try {

            DriverManager.getDriver()
                    .findElement(locator)
                    .clear();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to clear element : " + locator,
                    e);

        }

    }

    /**
     * Get visible text.
     *
     * @param locator element locator
     * @return element text
     */
    public String getText(By locator) {

        try {

            return DriverManager.getDriver()
                    .findElement(locator)
                    .getText();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to get text from element : " + locator,
                    e);

        }

    }

    /**
     * Check whether element is displayed.
     *
     * @param locator element locator
     * @return true if displayed
     */
    public boolean isDisplayed(By locator) {

        try {

            return DriverManager.getDriver()
                    .findElement(locator)
                    .isDisplayed();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to verify element visibility : " + locator,
                    e);

        }

    }

    /**
     * Check whether element is enabled.
     *
     * @param locator element locator
     * @return true if enabled
     */
    public boolean isEnabled(By locator) {

        try {

            return DriverManager.getDriver()
                    .findElement(locator)
                    .isEnabled();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to verify element enabled state : " + locator,
                    e);

        }

    }

    /**
     * Check whether element is selected.
     *
     * @param locator element locator
     * @return true if selected
     */
    public boolean isSelected(By locator) {

        try {

            return DriverManager.getDriver()
                    .findElement(locator)
                    .isSelected();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to verify element selected state : " + locator,
                    e);

        }

    }

    /**
     * Get attribute value.
     *
     * @param locator element locator
     * @param attribute attribute name
     * @return attribute value
     */
    public String getAttribute(By locator, String attribute) {

        try {

            return DriverManager.getDriver()
                    .findElement(locator)
                    .getAttribute(attribute);

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to get attribute '" + attribute +
                    "' from element : " + locator,
                    e);

        }

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

        try {

            Select select = new Select(
                    DriverManager.getDriver().findElement(locator));

            select.selectByVisibleText(text);

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to select visible text : " + text,
                    e);

        }

    }

    /**
     * Select dropdown option by value.
     *
     * @param locator dropdown locator
     * @param value option value
     */
    public void selectByValue(By locator, String value) {

        try {

            Select select = new Select(
                    DriverManager.getDriver().findElement(locator));

            select.selectByValue(value);

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to select value : " + value,
                    e);

        }

    }

    /**
     * Select dropdown option by index.
     *
     * @param locator dropdown locator
     * @param index option index
     */
    public void selectByIndex(By locator, int index) {

        try {

            Select select = new Select(
                    DriverManager.getDriver().findElement(locator));

            select.selectByIndex(index);

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to select index : " + index,
                    e);

        }

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

        try {

            WebElement element =
                    DriverManager.getDriver().findElement(locator);

            new Actions(DriverManager.getDriver())
                    .moveToElement(element)
                    .perform();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to hover over element : " + locator,
                    e);

        }

    }

    /**
     * Double click on an element.
     *
     * @param locator element locator
     */
    public void doubleClick(By locator) {

        try {

            WebElement element =
                    DriverManager.getDriver().findElement(locator);

            new Actions(DriverManager.getDriver())
                    .doubleClick(element)
                    .perform();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to double click element : " + locator,
                    e);

        }

    }

    /**
     * Right click on an element.
     *
     * @param locator element locator
     */
    public void rightClick(By locator) {

        try {

            WebElement element =
                    DriverManager.getDriver().findElement(locator);

            new Actions(DriverManager.getDriver())
                    .contextClick(element)
                    .perform();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to right click element : " + locator,
                    e);

        }

    }

    /**
     * Drag source element and drop it on target element.
     *
     * @param source source locator
     * @param target target locator
     */
    public void dragAndDrop(By source, By target) {

        try {

            WebElement sourceElement =
                    DriverManager.getDriver().findElement(source);

            WebElement targetElement =
                    DriverManager.getDriver().findElement(target);

            new Actions(DriverManager.getDriver())
                    .dragAndDrop(sourceElement, targetElement)
                    .perform();

        } catch (Exception e) {

            throw new ElementActionException(
                    "Unable to drag element from "
                            + source + " to " + target,
                    e);

        }

    }

}