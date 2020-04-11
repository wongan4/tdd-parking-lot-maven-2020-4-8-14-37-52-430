package com.oocl;

public class ParkingTicket {
    private final ParkingLot parkingLot;

    public ParkingTicket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
