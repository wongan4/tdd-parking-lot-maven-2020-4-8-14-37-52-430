package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private HashMap<ParkingTicket, Car> ticketToCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketToCarMap = new HashMap<ParkingTicket, Car>();
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
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

    public void validateTicket(ParkingTicket parkingTicket) throws UnrecognizedTicketException, NotProvideTicketException{
        if (parkingTicket == null) {
            throw new NotProvideTicketException("Please provide your parking ticket.");
        }
        if (!ticketToCarMap.containsKey(parkingTicket)) {
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
    }
}
