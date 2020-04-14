package com.oocl;

import com.oocl.exception.UnrecognizedTicketException;

import java.util.HashMap;

class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentCapacity;
    private int capacity;
    private HashMap<ParkingTicket, Car> ticketToCarMap;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = capacity;
        ticketToCarMap = new HashMap<>();
    }

    ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.currentCapacity = DEFAULT_CAPACITY;
        ticketToCarMap = new HashMap<>();
    }

    int getCurrentCapacity() {
        return this.currentCapacity;
    }

    double getAvailablePositionRate() {
        return ((double) this.getCurrentCapacity()) / this.capacity;
    }

    ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(this);
        this.ticketToCarMap.put(parkingTicket, car);
        this.currentCapacity -= 1;
        return parkingTicket;
    }

    Car getCarByTicket(ParkingTicket parkingTicket) {
        Car car = this.ticketToCarMap.get(parkingTicket);
        this.ticketToCarMap.remove(parkingTicket);
        this.currentCapacity += 1;
        return car;
    }

    void validateTicket(ParkingTicket parkingTicket) throws UnrecognizedTicketException {
        if (!ticketToCarMap.containsKey(parkingTicket)) {
            throw new UnrecognizedTicketException();
        }
    }
}
