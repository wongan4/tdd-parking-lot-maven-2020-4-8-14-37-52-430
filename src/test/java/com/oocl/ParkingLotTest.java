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
        this.parkingBoy = new ParkingBoy();
    }

    @Test
    public void should_return_ticket_when_park_car() {
        ParkingTicket parkingticket = this.parkingBoy.park(new Car());
        assertNotNull(parkingticket);
    }
}
