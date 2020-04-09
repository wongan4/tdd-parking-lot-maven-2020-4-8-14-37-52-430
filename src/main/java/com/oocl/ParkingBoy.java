package com.oocl;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingticket) {
        return this.parkingLot.getCarByTicket(parkingticket);
    }
}
