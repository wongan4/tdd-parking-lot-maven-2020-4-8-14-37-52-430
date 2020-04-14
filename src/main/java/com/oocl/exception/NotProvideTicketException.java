package com.oocl.exception;

public class NotProvideTicketException extends RuntimeException {

    public static final String NOT_PROVIDE_TICKET_EXCEPTION_MESSAGE = "Please provide your parking ticket.";

    public NotProvideTicketException() {
        super(NOT_PROVIDE_TICKET_EXCEPTION_MESSAGE);
    }
}
