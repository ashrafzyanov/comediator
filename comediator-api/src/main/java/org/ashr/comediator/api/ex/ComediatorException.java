package org.ashr.comediator.api.ex;

/** Base class for Comediator Exception. */
public class ComediatorException extends RuntimeException {

    public ComediatorException() {}

    public ComediatorException(final String message) {
        super(message);
    }

    public ComediatorException(final Throwable cause) {
        super(cause);
    }

    public ComediatorException(final String message, final Throwable cause) {
        super(message, cause);
    }

}