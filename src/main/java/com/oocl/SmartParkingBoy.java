package com.oocl;

import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends  ParkingBoy{
    @Override
    protected ParkingLot findAvailableParkingLot() {
        Optional<ParkingLot> availableParkingLot = this.managedParkingLots.stream()
                .filter(parkingLot -> parkingLot.getCapacity() > 0)
                .max(Comparator.comparing(ParkingLot::getCapacity));
        return availableParkingLot.orElse(null);
    }
}
