package com.mystk.market.data.exception;

/**
 * Exception for TuShare data process.
 */
public class TsDataException extends RuntimeException {

    public TsDataException(String message) {
        super(message);
    }

    public TsDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
