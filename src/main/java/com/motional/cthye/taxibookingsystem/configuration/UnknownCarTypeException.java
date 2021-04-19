package com.motional.cthye.taxibookingsystem.configuration;

public class UnknownCarTypeException extends Exception {
    public UnknownCarTypeException() {
        super();
    }

    public UnknownCarTypeException(String message) {
        super(message);
    }

    public UnknownCarTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCarTypeException(Throwable cause) {
        super(cause);
    }

    public UnknownCarTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
