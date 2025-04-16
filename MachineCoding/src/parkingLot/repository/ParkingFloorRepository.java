package parkingLot.repository;

import parkingLot.exception.ParkingFloorNotFoundException;
import parkingLot.models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> parkingFloorMap;
    private static int parkingFloorIdCounter;

    public ParkingFloorRepository() {
        parkingFloorIdCounter = 0;
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int id) throws ParkingFloorNotFoundException {
        ParkingFloor parkingSpot = parkingFloorMap.get(id);
        if(parkingSpot == null){
            throw new ParkingFloorNotFoundException("Parking Floor not found for the id : " + id);
        }
        return parkingSpot;
    }

    public void put(ParkingFloor parkingFloor){
        parkingFloor.setId(++parkingFloorIdCounter);
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
    }
}
