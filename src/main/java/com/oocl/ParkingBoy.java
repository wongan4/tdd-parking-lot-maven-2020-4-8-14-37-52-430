package com.oocl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    public static final String NOT_ENOUGH_POSITION_EXCEPTION_MESSAGE = "Not enough position";
    public static final String UNMANAGED_TICKET_EXCEPTION = "Ticket is not managed by this parking boy.";
    public static final String NOT_PROVIDE_TICKET_EXCEPTION_MESSAGE = "Please provide your parking ticket.";

    private List<ParkingLot> managedParkingLots;

    public ParkingBoy(List<ParkingLot> managedParkingLots) {
        this.managedParkingLots = managedParkingLots;
    }

    public ParkingBoy() {
        this.managedParkingLots = new ArrayList<ParkingLot>();
    }

    public void addParkingLot (ParkingLot parkingLot) {
        this.managedParkingLots.add(parkingLot);
    }

    private ParkingLot findAvailableParkingLot() {
        Optional<ParkingLot> availableParkingLot =
                this.managedParkingLots.stream().filter(parkingLot -> parkingLot.getCapacity() > 0).findFirst();
        return availableParkingLot.orElse(null);
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        ParkingLot availableParkingLot = this.findAvailableParkingLot();

        if (availableParkingLot == null) {
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION_EXCEPTION_MESSAGE);
        }
        return availableParkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket)
            throws UnrecognizedTicketException, NotProvideTicketException, UnmanagedTicketException {
        if (parkingTicket == null) {
            throw new NotProvideTicketException(NOT_PROVIDE_TICKET_EXCEPTION_MESSAGE);
        }

        ParkingLot ticketParkingLot = parkingTicket.getParkingLot();

        if (!this.managedParkingLots.contains(ticketParkingLot)) {
            throw new UnmanagedTicketException(UNMANAGED_TICKET_EXCEPTION);
        }
        ticketParkingLot.validateTicket(parkingTicket);
        return ticketParkingLot.getCarByTicket(parkingTicket);
    }
}
