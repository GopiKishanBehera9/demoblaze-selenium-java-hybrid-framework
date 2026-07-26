package com.demoblaze.exceptions;

/**
 * Exception thrown for unsupported browser.
 *
 * @author Gopi Kishan Behera
 */
public class InvalidBrowserException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public InvalidBrowserException(String message) {
        super(message);
    }

}