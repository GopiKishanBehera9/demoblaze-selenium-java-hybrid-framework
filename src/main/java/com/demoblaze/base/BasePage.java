package com.demoblaze.base;

import org.openqa.selenium.WebDriver;

import com.demoblaze.driver.DriverManager;
import com.demoblaze.wrappers.ElementActions;

/**
 * BasePage
 *
 * Parent class for all Page Objects.
 *
 * @author Gopi Kishan Behera
 */
public class BasePage {

    protected WebDriver driver;

    protected ElementActions actions;

    public BasePage() {

        driver = DriverManager.getDriver();

        actions = new ElementActions();

    }

}