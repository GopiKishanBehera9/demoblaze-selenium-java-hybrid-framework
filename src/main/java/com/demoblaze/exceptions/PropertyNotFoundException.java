package com.demoblaze.exceptions;

/**
 * Exception thrown when a property key is missing.
 *
 * @author Gopi Kishan Behera
 */
public class PropertyNotFoundException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public PropertyNotFoundException(String message) {
        super(message);
    }

}