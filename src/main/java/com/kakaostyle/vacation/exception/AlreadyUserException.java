package com.kakaostyle.vacation.exception;

public class AlreadyUserException extends RuntimeException {
    public AlreadyUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public AlreadyUserException(String msg) {
        super(msg);
    }

    public AlreadyUserException() {
        super();
    }
}
