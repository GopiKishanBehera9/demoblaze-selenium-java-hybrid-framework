package com.demoblaze.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.exceptions.ScreenshotException;

/**
 * ScreenshotUtils
 *
 * Utility class for capturing Selenium screenshots.
 *
 * @author Gopi Kishan Behera
 */
public final class ScreenshotUtils {

    private ScreenshotUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Capture screenshot.
     *
     * @param screenshotName screenshot name
     * @return absolute screenshot path
     */
    public static String captureScreenshot(String screenshotName) {

        try {

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String fileName = screenshotName + "_" + timeStamp + ".png";

            String destination =
                    FrameworkConstants.SCREENSHOT_PATH + fileName;

            File source = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            File target = new File(destination);

            FileUtils.copyFile(source, target);

            return target.getAbsolutePath();

        } catch (IOException e) {

            throw new ScreenshotException(
                    "Unable to capture screenshot.",
                    e);

        }

    }

}