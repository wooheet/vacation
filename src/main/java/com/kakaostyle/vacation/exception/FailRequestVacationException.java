package com.kakaostyle.vacation.exception;

public class FailRequestVacationException extends RuntimeException {
    public FailRequestVacationException(String msg, Throwable t) {
        super(msg, t);
    }

    public FailRequestVacationException(String msg) {
        super(msg);
    }

    public FailRequestVacationException() {
        super();
    }
}
