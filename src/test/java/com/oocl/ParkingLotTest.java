package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private ParkingBoy parkingBoy;

    @Before
    public void setup() {
        this.parkingLot = new ParkingLot();
        this.parkingBoy = new ParkingBoy(parkingLot);
    }

    @Test
    public void should_return_ticket_when_park_car() {
        ParkingTicket parkingticket = this.parkingBoy.park(new Car());
        assertNotNull(parkingticket);
    }

    @Test
    public void should_return_car_when_give_ticket() {
        ParkingTicket parkingticket = this.parkingBoy.park(new Car());
        Car car = this.parkingBoy.fetch(parkingticket);
        assertNotNull(car);
    }
}
