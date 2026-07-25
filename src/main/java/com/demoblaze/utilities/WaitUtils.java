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
 * Utility class for Explicit Wait operations.
 *
 * @author Gopi Kishan Behera
 */
public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils() {

        this.driver = DriverManager.getDriver();

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.getProperty("explicit.wait"))));

    }

    /**
     * Wait until element is visible.
     */
    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    /**
     * Wait until element is clickable.
     */
    public WebElement waitForElementToBeClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    /**
     * Wait until element is present.
     */
    public WebElement waitForPresence(By locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    /**
     * Wait until title contains expected text.
     */
    public boolean waitForTitleContains(String title) {

        return wait.until(ExpectedConditions.titleContains(title));

    }

    /**
     * Wait until URL contains expected text.
     */
    public boolean waitForUrlContains(String url) {

        return wait.until(ExpectedConditions.urlContains(url));

    }

}