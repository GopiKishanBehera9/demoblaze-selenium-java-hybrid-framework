package com.demoblaze.exceptions;

/**
 * Exception thrown during explicit wait operations.
 *
 * @author Gopi Kishan Behera
 */
public class WaitException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public WaitException(String message) {
        super(message);
    }

    public WaitException(String message, Throwable cause) {
        super(message, cause);
    }

}