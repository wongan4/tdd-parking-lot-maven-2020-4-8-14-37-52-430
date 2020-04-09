package com.oocl;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            System.out.println("Cannot fetch car because customer provide a null ticket");
            return null;
        }
        return this.parkingLot.getCarByTicket(parkingTicket);
    }

    public Car fetch() {
        System.out.println("Cannot fetch car because customer fails to provide a ticket");
        return null;
    }
}
