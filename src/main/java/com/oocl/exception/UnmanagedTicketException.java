package com.oocl.exception;

public class UnmanagedTicketException extends Throwable {
    public static final String UNMANAGED_TICKET_EXCEPTION = "Ticket is not managed by this parking boy.";

    public UnmanagedTicketException() {
        super(UNMANAGED_TICKET_EXCEPTION);
    }
}
