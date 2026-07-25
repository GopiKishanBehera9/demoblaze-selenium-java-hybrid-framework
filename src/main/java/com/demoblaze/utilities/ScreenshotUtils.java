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
     * @param screenshotName screenshot file name
     * @return absolute screenshot path
     */
    public static String captureScreenshot(String screenshotName) {

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String fileName = screenshotName + "_" + timeStamp + ".png";

        File folder = new File(FrameworkConstants.SCREENSHOT_PATH);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File source = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File target = new File(folder, fileName);

        try {

            FileUtils.copyFile(source, target);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot.", e);

        }

        return target.getAbsolutePath();
    }
}