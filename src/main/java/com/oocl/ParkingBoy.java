package com.oocl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    protected List<ParkingLot> managedParkingLots;

    public ParkingBoy() {
        this.managedParkingLots = new ArrayList<ParkingLot>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.managedParkingLots.add(parkingLot);
    }

    public void removeParkingLot(ParkingLot parkingLot) {
        this.managedParkingLots.remove(parkingLot);
    }

    protected ParkingLot findAvailableParkingLot() {
        Optional<ParkingLot> availableParkingLot =
                this.managedParkingLots.stream()
                        .filter(parkingLot -> parkingLot.getCurrentCapacity() > 0)
                        .findFirst();
        return availableParkingLot.orElse(null);
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        ParkingLot availableParkingLot = this.findAvailableParkingLot();

        if (availableParkingLot == null) {
            throw new NotEnoughPositionException();
        }
        return availableParkingLot.park(car);
    }

    public ParkingTicket parkTo(Car car, ParkingLot desiredParkingLot)
            throws UnmanagedParkingLogException, NotEnoughPositionException{
        if (!this.managedParkingLots.contains(desiredParkingLot)) {
            throw new UnmanagedParkingLogException();
        }
        if (desiredParkingLot.getCurrentCapacity() <= 0) {
            throw new NotEnoughPositionException();
        }
        return desiredParkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket)
            throws UnrecognizedTicketException, NotProvideTicketException, UnmanagedTicketException {
        if (parkingTicket == null) {
            throw new NotProvideTicketException();
        }

        ParkingLot ticketParkingLot = parkingTicket.getParkingLot();

        if (!this.managedParkingLots.contains(ticketParkingLot)) {
            throw new UnmanagedTicketException();
        }
        ticketParkingLot.validateTicket(parkingTicket);
        return ticketParkingLot.getCarByTicket(parkingTicket);
    }
}
