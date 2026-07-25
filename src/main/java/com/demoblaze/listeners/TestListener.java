package com.demoblaze.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demoblaze.utilities.ScreenshotUtils;

/**
 * TestListener
 *
 * Handles TestNG events such as test start, success,
 * failure, skip, and suite execution.
 *
 * @author Gopi Kishan Behera
 */
public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {

        logger.info("===========================================");
        logger.info("Execution Started : {}", context.getName());
        logger.info("===========================================");

    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("===========================================");
        logger.info("Execution Finished : {}", context.getName());
        logger.info("===========================================");

    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("STARTED : {}", result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("PASSED : {}", result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("FAILED : {}", result.getMethod().getMethodName());

        logger.error(result.getThrowable());

        String screenshot =
                ScreenshotUtils.captureScreenshot(
                        result.getMethod().getMethodName());

        logger.info("Screenshot : {}", screenshot);

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("SKIPPED : {}", result.getMethod().getMethodName());

    }

}