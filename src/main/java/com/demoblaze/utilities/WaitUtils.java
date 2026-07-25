package com.demoblaze.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoblaze.config.ConfigReader;
import com.demoblaze.driver.DriverManager;

/**
 * WaitUtils
 *
 * Utility class for Explicit Wait operations.
 * Provides reusable wait methods for WebDriver.
 *
 * @author Gopi Kishan Behera
 */
public final class WaitUtils {

    private final WebDriver driver;

    private final WebDriverWait wait;

    /**
     * Initializes WebDriverWait using timeout from config.properties.
     */
    public WaitUtils() {

        this.driver = DriverManager.getDriver();

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("explicit.wait"))));

    }

    // ==========================
    // Element Waits
    // ==========================

    /**
     * Wait until element is visible.
     *
     * @param locator element locator
     * @return visible WebElement
     */
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

    }

    /**
     * Wait until element is clickable.
     *
     * @param locator element locator
     * @return clickable WebElement
     */
    public WebElement waitForElementToBeClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));

    }

    /**
     * Wait until element is present in DOM.
     *
     * @param locator element locator
     * @return present WebElement
     */
    public WebElement waitForPresence(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

    }

    /**
     * Wait until element becomes invisible.
     *
     * @param locator element locator
     * @return true if invisible
     */
    public boolean waitForInvisibility(By locator) {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    /**
     * Wait until element contains expected text.
     *
     * @param locator element locator
     * @param text expected text
     * @return true if text is present
     */
    public boolean waitForText(By locator, String text) {

        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator,
                        text));

    }

    /**
     * Wait until attribute contains expected value.
     *
     * @param locator element locator
     * @param attribute attribute name
     * @param value expected value
     * @return true if attribute contains value
     */
    public boolean waitForAttribute(By locator,
                                    String attribute,
                                    String value) {

        return wait.until(
                ExpectedConditions.attributeContains(
                        locator,
                        attribute,
                        value));

    }

    // ==========================
    // Browser Waits
    // ==========================

    /**
     * Wait until page title contains expected text.
     *
     * @param title expected title
     * @return true if title contains text
     */
    public boolean waitForTitleContains(String title) {

        return wait.until(
                ExpectedConditions.titleContains(title));

    }

    /**
     * Wait until current URL contains expected text.
     *
     * @param url expected URL text
     * @return true if URL contains text
     */
    public boolean waitForUrlContains(String url) {

        return wait.until(
                ExpectedConditions.urlContains(url));

    }

    /**
     * Wait until alert is present.
     */
    public void waitForAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent());

    }

}