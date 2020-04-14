package com.oocl;

import com.oocl.exception.NotEnoughPositionException;
import com.oocl.exception.NotProvideTicketException;
import com.oocl.exception.UnmanagedTicketException;
import com.oocl.exception.UnrecognizedTicketException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private ParkingBoy parkingBoy;
    private Car car1;
    private Car car2;


    @Before
    public void setup() {
        this.parkingLot = new ParkingLot();
        this.parkingBoy = new ParkingBoy();
        this.parkingBoy.addParkingLot(this.parkingLot);
        this.car1 = new Car(1);
        this.car2 = new Car(2);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_ticket_when_park_car() {
        ParkingTicket parkingTicket = this.parkingBoy.park(car1);

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_give_ticket() throws UnmanagedTicketException {
        ParkingTicket parkingTicket = this.parkingBoy.park(car1);
        Car car = this.parkingBoy.fetch(parkingTicket);

        assertNotNull(car);
    }

    @Test
    public void should_fetch_right_car_when_give_corresponding_ticket() throws UnmanagedTicketException {
        ParkingTicket parkingTicket1 = this.parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = this.parkingBoy.park(car2);
        Car obtainedCar1 = this.parkingBoy.fetch(parkingTicket1);
        Car obtainedCar2 = this.parkingBoy.fetch(parkingTicket2);

        assertEquals(car1, obtainedCar1);
        assertEquals(car2, obtainedCar2);
        assertNotEquals(obtainedCar1, obtainedCar2);
    }

    @Test
    public void should_not_fetch_car_when_not_provide_ticket() throws UnmanagedTicketException {
        expectedException.expect(NotProvideTicketException.class);
        expectedException.expectMessage(NotProvideTicketException.NOT_PROVIDE_TICKET_EXCEPTION_MESSAGE);
        Car car = this.parkingBoy.fetch(null);
    }

    @Test
    public void should_not_fetch_car_when_give_used_ticket() throws UnmanagedTicketException {
        expectedException.expect(UnrecognizedTicketException.class);
        expectedException.expectMessage(UnrecognizedTicketException.UNRECOGNIZED_TICKET_EXCEPTION_MESSAGE);
        ParkingTicket ticket = this.parkingBoy.park(car1);
        this.parkingBoy.fetch(ticket);
        this.parkingBoy.fetch(ticket);
    }

    @Test
    public void should_not_fetch_car_when_parking_lot_is_full() {
        expectedException.expect(NotEnoughPositionException.class);
        expectedException.expectMessage(NotEnoughPositionException.NOT_ENOUGH_POSITION_EXCEPTION_MESSAGE);
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoyOnSmallLot = new ParkingBoy();
        parkingBoyOnSmallLot.addParkingLot(smallParkingLot);
        ParkingTicket parkingTicket1 = parkingBoyOnSmallLot.park(car1);
        ParkingTicket parkingTicket2 = parkingBoyOnSmallLot.park(car2);

        assertNotNull(parkingTicket1);
        assertNull(parkingTicket2);
    }
}
