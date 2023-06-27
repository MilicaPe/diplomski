package com.ftn.sbnz.service.exception;

public class AlreadyInUseException extends RuntimeException {

    public AlreadyInUseException() {}

    public AlreadyInUseException(String message) {
        super(message);
    }
}
