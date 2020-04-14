package com.oocl.exception;

public class UnrecognizedTicketException extends RuntimeException {
    public static final String UNRECOGNIZED_TICKET_EXCEPTION_MESSAGE = "Unrecognized parking ticket.";

    public UnrecognizedTicketException() {
        super(UNRECOGNIZED_TICKET_EXCEPTION_MESSAGE);
    }
}
