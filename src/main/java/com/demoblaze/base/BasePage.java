package com.demoblaze.base;

import org.openqa.selenium.WebDriver;

import com.demoblaze.driver.DriverManager;

/**
 * BasePage
 *
 * Parent class for all Page Objects.
 *
 * @author Gopi Kishan Behera
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

}