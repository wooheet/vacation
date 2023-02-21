package com.kakaostyle.vacation.exception;

public class CanNotBeUsedVacationException extends RuntimeException {
    public CanNotBeUsedVacationException(String msg, Throwable t) {
        super(msg, t);
    }

    public CanNotBeUsedVacationException(String msg) {
        super(msg);
    }

    public CanNotBeUsedVacationException() {
        super();
    }
}
