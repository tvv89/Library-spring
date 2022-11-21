package com.epam.spring.library.exception;

public class EntityIllegalArgumentException extends RuntimeException {

    public EntityIllegalArgumentException(String message, Exception exception) {

        super(message, exception);
    }

}
