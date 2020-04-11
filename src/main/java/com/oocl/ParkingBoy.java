package com.oocl;

public class ParkingBoy {
    private static final String NOT_ENOUGH_SPACE_EXCEPTION_MESSAGE = "Not enough position";

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        if (this.parkingLot.getCapacity() == 0) {
            throw new NotEnoughPositionException(NOT_ENOUGH_SPACE_EXCEPTION_MESSAGE);
        }
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedTicketException, NotProvideTicketException{
        this.parkingLot.validateTicket(parkingTicket);
        return this.parkingLot.getCarByTicket(parkingTicket);
    }
}
