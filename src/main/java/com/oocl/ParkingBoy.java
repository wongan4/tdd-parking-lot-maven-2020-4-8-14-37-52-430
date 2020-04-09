package com.oocl;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingticket) {
        Car car = new Car();
        return car;
    }
}
