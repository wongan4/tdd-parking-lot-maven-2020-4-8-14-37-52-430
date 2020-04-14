package com.oocl;

class ParkingTicket {
    private final ParkingLot parkingLot;

    ParkingTicket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    ParkingLot getParkingLot() {
        return parkingLot;
    }
}
