package com.demoblaze.exceptions;

/**
 * Exception thrown while capturing screenshots.
 *
 * @author Gopi Kishan Behera
 */
public class ScreenshotException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public ScreenshotException(String message) {
        super(message);
    }

    public ScreenshotException(String message, Throwable cause) {
        super(message, cause);
    }

}