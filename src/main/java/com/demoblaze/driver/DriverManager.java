package com.demoblaze.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager
 *
 * Manages WebDriver instance using ThreadLocal for thread-safe execution.
 *
 * @author Gopi Kishan Behera
 */
public final class DriverManager {

    private DriverManager() {
        throw new IllegalStateException("Utility class");
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Sets WebDriver instance.
     *
     * @param webDriver WebDriver instance
     */
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    /**
     * Returns current thread WebDriver.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Removes current thread WebDriver.
     */
    public static void unload() {
        driver.remove();
    }

}