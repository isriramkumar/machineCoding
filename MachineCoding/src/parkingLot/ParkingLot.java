package parkingLot;

import parkingLot.Constants.ParkingLotStatus;
import parkingLot.Constants.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String Name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> supportedVehicleTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;

}
