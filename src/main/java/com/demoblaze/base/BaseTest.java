package com.demoblaze.base;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoblaze.config.PropertyManager;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.factory.DriverFactory;
import com.demoblaze.utilities.LoggerUtils;

/**
 * BaseTest
 *
 * Initializes and quits browser before and after every test method.
 *
 * @author Gopi Kishan Behera
 */
public class BaseTest {

    private static final Logger logger = LoggerUtils.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        logger.info("========== Test Execution Started ==========");

        DriverFactory.initDriver();

        logger.info("Browser launched successfully.");

        DriverManager.getDriver().get(
                PropertyManager.getEnvironmentProperty("app.url"));

        logger.info("Application URL opened successfully.");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info("Closing browser.");

        DriverFactory.quitDriver();

        logger.info("========== Test Execution Finished ==========");

    }

}