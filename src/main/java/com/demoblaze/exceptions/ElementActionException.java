package com.demoblaze.exceptions;

/**
 * Exception thrown during element interaction.
 *
 * @author Gopi Kishan Behera
 */
public class ElementActionException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public ElementActionException(String message) {
        super(message);
    }

    public ElementActionException(String message, Throwable cause) {
        super(message, cause);
    }

}