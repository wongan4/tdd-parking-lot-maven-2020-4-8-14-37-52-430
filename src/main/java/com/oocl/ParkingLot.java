package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    public static final String UNRECOGNIZED_TICKET_EXCEPTION_MESSAGE = "Unrecognized parking ticket.";

    private int currentCapacity;
    private int capacity;
    private HashMap<ParkingTicket, Car> ticketToCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = capacity;
        ticketToCarMap = new HashMap<ParkingTicket, Car>();
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.currentCapacity = DEFAULT_CAPACITY;
        ticketToCarMap = new HashMap<ParkingTicket, Car>();
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public double getAvailablePositionRate() {
        return ((double) this.getCurrentCapacity()) / this.capacity;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket(this);
        this.ticketToCarMap.put(parkingTicket, car);
        this.currentCapacity -= 1;
        return parkingTicket;
    }

    public Car getCarByTicket(ParkingTicket parkingTicket) {
        Car car = this.ticketToCarMap.get(parkingTicket);
        this.ticketToCarMap.remove(parkingTicket);
        this.currentCapacity += 1;
        return car;
    }

    public void validateTicket(ParkingTicket parkingTicket) throws UnrecognizedTicketException{
        if (!ticketToCarMap.containsKey(parkingTicket)) {
            throw new UnrecognizedTicketException(UNRECOGNIZED_TICKET_EXCEPTION_MESSAGE);
        }
    }
}
