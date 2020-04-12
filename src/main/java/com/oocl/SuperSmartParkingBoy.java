package com.oocl;

import java.util.Comparator;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    protected ParkingLot findAvailableParkingLot() {
        Optional<ParkingLot> availableParkingLot = this.managedParkingLots.stream()
                .filter(parkingLot -> parkingLot.getCurrentCapacity() > 0)
                .max(Comparator.comparing(ParkingLot::getCurrentCapacity));
        return availableParkingLot.orElse(null);
    }
}
