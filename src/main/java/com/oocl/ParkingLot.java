package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private HashMap<ParkingTicket, Car> ticketToCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketToCarMap = new HashMap<ParkingTicket, Car>();
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.ticketToCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car getCarByTicket(ParkingTicket parkingTicket) {
        return this.ticketToCarMap.get(parkingTicket);
    }
}
