package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private HashMap<ParkingTicket, Car> ticketToCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketToCarMap = new HashMap<ParkingTicket, Car>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.ticketToCarMap.put(parkingTicket, car);
        this.capacity -= 1;
        return parkingTicket;
    }

    public Car getCarByTicket(ParkingTicket parkingTicket) {
        Car car = this.ticketToCarMap.get(parkingTicket);
        this.ticketToCarMap.remove(parkingTicket);
        return car;
    }
}
