package com.oocl;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (this.parkingLot.getCapacity() == 0) {
            System.out.println("Cannot park car because parking lot is full");
            return null;
        }
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null || parkingTicket.isUsed()) {
            System.out.println("Cannot fetch car because customer provide a invalid ticket");
            return null;
        }
        return this.parkingLot.getCarByTicket(parkingTicket);
    }

    public Car fetch() {
        System.out.println("Cannot fetch car because customer fails to provide a ticket");
        return null;
    }
}
