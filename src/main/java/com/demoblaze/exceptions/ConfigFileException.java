package com.demoblaze.exceptions;

/**
 * Exception thrown while reading configuration files.
 *
 * @author Gopi Kishan Behera
 */
public class ConfigFileException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public ConfigFileException(String message) {
        super(message);
    }

    public ConfigFileException(String message, Throwable cause) {
        super(message, cause);
    }

}