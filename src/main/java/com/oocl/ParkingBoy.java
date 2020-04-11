package com.oocl;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        if (this.parkingLot.getCapacity() == 0) {
            throw new NotEnoughPositionException("Not enough position");
        }
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedTicketException, NotProvideTicketException{
        this.parkingLot.validateTicket(parkingTicket);
        return this.parkingLot.getCarByTicket(parkingTicket);
    }
}
