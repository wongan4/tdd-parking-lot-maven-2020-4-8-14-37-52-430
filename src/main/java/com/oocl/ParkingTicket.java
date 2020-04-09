package com.oocl;

public class ParkingTicket {
    private static final int DEFAULT_USAGE_LIMIT = 1;
    private int usageCount;

    public ParkingTicket() {
        usageCount = DEFAULT_USAGE_LIMIT;
    }

    public void decreaseUsageCount(int decreaseAmount) {
        this.usageCount -= decreaseAmount;
    }

    public boolean isUsed() {
        return this.usageCount == 0;
    }
}
