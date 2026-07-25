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

        try {

            System.out.println("========== BaseTest ==========");
            System.out.println("Before initDriver");

            DriverFactory.initDriver();

            System.out.println("After initDriver");

            logger.info("Browser launched successfully.");

            String appUrl = PropertyManager.getEnvironmentProperty("app.url");

            System.out.println("Application URL : " + appUrl);

            DriverManager.getDriver().get(appUrl);

            System.out.println("URL Opened Successfully");

            logger.info("Application URL opened successfully.");

        } catch (Exception e) {

            System.err.println("Exception occurred in BaseTest.setUp()");
            e.printStackTrace();

            throw e;
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info("Closing browser.");

        if (DriverManager.getDriver() != null) {
            DriverFactory.quitDriver();
        }

        logger.info("========== Test Execution Finished ==========");
    }

}