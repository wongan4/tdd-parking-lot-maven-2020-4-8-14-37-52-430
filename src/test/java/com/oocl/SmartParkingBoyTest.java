package com.oocl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {
    private ParkingLot parkingLot;
    private SmartParkingBoy smartParkingBoy;

    @Before
    public void setup() {
        this.parkingLot = new ParkingLot(5);
        this.smartParkingBoy = new SmartParkingBoy();
        this.smartParkingBoy.addParkingLot(this.parkingLot);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_parking_lot_with_more_empty_position_when_park_car() {
        ParkingLot mediumParkingLot = new ParkingLot(4);
        ParkingLot smallParkingLot = new ParkingLot(3);
        this.smartParkingBoy.addParkingLot(mediumParkingLot);
        this.smartParkingBoy.addParkingLot(smallParkingLot);

        ParkingTicket parkingTicket1 = this.smartParkingBoy.park(new Car(1));
        ParkingTicket parkingTicket2 = this.smartParkingBoy.parkTo(new Car(2), this.parkingLot);
        ParkingTicket parkingTicket3 = this.smartParkingBoy.park(new Car(3));

        assertEquals(this.parkingLot, parkingTicket1.getParkingLot());
        assertEquals(this.parkingLot, parkingTicket2.getParkingLot());
        assertEquals(mediumParkingLot, parkingTicket3.getParkingLot());
    }
}