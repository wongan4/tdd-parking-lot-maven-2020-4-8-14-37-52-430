package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private ParkingBoy parkingBoy;
    private Car car1;
    private Car car2;


    @Before
    public void setup() {
        this.parkingLot = new ParkingLot(10);
        this.parkingBoy = new ParkingBoy(parkingLot);
        this.car1 = new Car(1);
        this.car2 = new Car(2);
    }

    @Test
    public void should_return_ticket_when_park_car() {
        ParkingTicket parkingTicket = this.parkingBoy.park(car1);

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_give_ticket() {
        ParkingTicket parkingTicket = this.parkingBoy.park(car1);
        Car car = this.parkingBoy.fetch(parkingTicket);

        assertNotNull(car);
    }

    @Test
    public void should_fetch_right_car_when_give_corresponding_ticket() {
        ParkingTicket parkingTicket1 = this.parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = this.parkingBoy.park(car2);
        Car obtainedCar1 = this.parkingBoy.fetch(parkingTicket1);
        Car obtainedCar2 = this.parkingBoy.fetch(parkingTicket2);

        assertEquals(car1, obtainedCar1);
        assertEquals(car2, obtainedCar2);
        assertNotEquals(obtainedCar1, obtainedCar2);
    }

    @Test
    public void should_not_fetch_car_when_give_wrong_ticket() {
        Car car = this.parkingBoy.fetch(null);
        assertNull(car);
    }

    @Test
    public void should_not_fetch_car_when_not_give_ticket() {
        Car car = this.parkingBoy.fetch();
        assertNull(car);
    }
}
