package parkingLot.exception;

public class NoParkingSlotAvailableException extends Exception{
    public NoParkingSlotAvailableException(String message) {
        super(message);
    }

    public NoParkingSlotAvailableException() {
    }
}
