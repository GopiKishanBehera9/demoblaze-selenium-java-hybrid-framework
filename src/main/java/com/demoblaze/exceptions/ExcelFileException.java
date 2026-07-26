package com.demoblaze.exceptions;

/**
 * Exception thrown while reading Excel files.
 *
 * @author Gopi Kishan Behera
 */
public class ExcelFileException extends FrameworkException {

    private static final long serialVersionUID = 1L;

    public ExcelFileException(String message) {
        super(message);
    }

    public ExcelFileException(String message, Throwable cause) {
        super(message, cause);
    }

}