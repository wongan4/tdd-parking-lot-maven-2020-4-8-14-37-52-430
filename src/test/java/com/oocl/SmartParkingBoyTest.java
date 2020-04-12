package com.oocl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {
    private ParkingLot parkingLot;
    private SmartParkingBoy smartParkingBoy;
    private Car car1;
    private Car car2;

    @Before
    public void setup() {
        this.parkingLot = new ParkingLot(10);
        this.smartParkingBoy = new SmartParkingBoy();
        this.smartParkingBoy.addParkingLot(this.parkingLot);
        this.car1 = new Car(1);
        this.car2 = new Car(2);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_parking_lot_with_more_empty_position_when_park_car() {
        ParkingLot mediumParkingLot = new ParkingLot(5);
        ParkingLot smallParkingLot = new ParkingLot(1);
        this.smartParkingBoy.addParkingLot(mediumParkingLot);
        this.smartParkingBoy.addParkingLot(smallParkingLot);
        ParkingTicket parkingTicket = this.smartParkingBoy.park(car1);

        assertEquals(this.parkingLot, parkingTicket.getParkingLot());
    }
}