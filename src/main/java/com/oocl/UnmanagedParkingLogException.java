package com.oocl;

public class UnmanagedParkingLogException extends RuntimeException {
    public static final String UNMANAGED_PARKING_LOT_EXCEPTION = "Parking lot is not managed by this parking boy.";

    public UnmanagedParkingLogException() {
        super(UNMANAGED_PARKING_LOT_EXCEPTION);
    }
}
