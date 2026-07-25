package com.demoblaze.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for Log4j2 logger.
 *
 * @author Gopi Kishan Behera
 */
public final class LoggerUtils {

    private LoggerUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

}