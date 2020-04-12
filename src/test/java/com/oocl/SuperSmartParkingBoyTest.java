package com.oocl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SuperSmartParkingBoyTest {
    private ParkingLot largeParkingLot;
    private SuperSmartParkingBoy superSmartParkingBoy;

    @Before
    public void setup() {
        this.largeParkingLot = new ParkingLot(5);
        this.superSmartParkingBoy = new SuperSmartParkingBoy();
        this.superSmartParkingBoy.addParkingLot(this.largeParkingLot);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_parking_lot_with_highest_available_position_rate_when_park_car() {
        ParkingLot mediumParkingLot = new ParkingLot(3);
        ParkingLot smallParkingLot = new ParkingLot(2);
        this.superSmartParkingBoy.addParkingLot(mediumParkingLot);
        this.superSmartParkingBoy.addParkingLot(smallParkingLot);

        ParkingTicket parkingTicket1 = this.superSmartParkingBoy.parkTo(new Car(1), this.largeParkingLot);
        ParkingTicket parkingTicket2 = this.superSmartParkingBoy.park(new Car(2));
        assertEquals(mediumParkingLot, parkingTicket2.getParkingLot());

        this.superSmartParkingBoy.removeParkingLot(this.largeParkingLot);
        ParkingTicket parkingTicket3 = this.superSmartParkingBoy.park(new Car(3));
        assertEquals(smallParkingLot, parkingTicket3.getParkingLot());

        ParkingTicket parkingTicket4 = this.superSmartParkingBoy.park(new Car(4));
        assertEquals(mediumParkingLot, parkingTicket4.getParkingLot());
    }
}