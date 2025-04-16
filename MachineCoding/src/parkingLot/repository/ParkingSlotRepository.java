package parkingLot.repository;

import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.ParkingSlotNotFoundException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {
    private HashMap<Integer, ParkingSlot> parkingSlotMap;
    private static int parkingSlotIdCounter;

    public ParkingSlotRepository() {
        parkingSlotIdCounter = 0;
        this.parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int id) throws ParkingSlotNotFoundException {
        ParkingSlot parkingSpot = parkingSlotMap.get(id);
        if(parkingSpot == null){
            throw new ParkingSlotNotFoundException("Parking Slot not found for the id : " + id);
        }
        return parkingSpot;
    }

    public void put(ParkingSlot parkingSlot){
        parkingSlot.setId(++parkingSlotIdCounter);
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
    }
}
