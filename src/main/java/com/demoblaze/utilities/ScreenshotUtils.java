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

/**
 * ScreenshotUtils
 *
 * Utility class for capturing screenshots.
 *
 * @author Gopi Kishan Behera
 */
public final class ScreenshotUtils {

    private ScreenshotUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Captures screenshot and returns saved file path.
     *
     * @param fileName Screenshot name
     * @return Screenshot path
     */
    public static String captureScreenshot(String fileName) {

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String destination = FrameworkConstants.SCREENSHOT_PATH
                + fileName + "_" + timeStamp + ".png";

        File source = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File target = new File(destination);

        try {

            FileUtils.copyFile(source, target);

        } catch (IOException e) {

            throw new RuntimeException("Unable to capture screenshot.", e);

        }

        return destination;

    }

}