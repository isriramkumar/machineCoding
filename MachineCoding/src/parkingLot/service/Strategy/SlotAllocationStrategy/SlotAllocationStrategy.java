package parkingLot.service.Strategy.SlotAllocationStrategy;

import parkingLot.exception.NoParkingSlotAvailableException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSlot;
import parkingLot.models.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) throws NoParkingSlotAvailableException;
}
