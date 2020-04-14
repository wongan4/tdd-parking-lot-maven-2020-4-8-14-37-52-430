package com.oocl.exception;

public class NotEnoughPositionException extends RuntimeException{
    public static final String NOT_ENOUGH_POSITION_EXCEPTION_MESSAGE = "Not enough position";

    public NotEnoughPositionException() {
        super(NOT_ENOUGH_POSITION_EXCEPTION_MESSAGE);
    }
}
