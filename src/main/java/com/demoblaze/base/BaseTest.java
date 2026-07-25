package com.demoblaze.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoblaze.config.PropertyManager;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.factory.DriverFactory;

/**
 * BaseTest
 *
 * Initializes and quits browser before and after every test method.
 *
 * @author Gopi Kishan Behera
 */
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        DriverFactory.initDriver();

        DriverManager.getDriver().get(
                PropertyManager.getEnvironmentProperty("app.url"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();

    }

}