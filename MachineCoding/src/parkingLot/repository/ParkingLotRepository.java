package parkingLot.repository;

import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> parkingLotMap;
    private static int parkingLotIdCounter;

    public ParkingLotRepository() {
        parkingLotIdCounter = 0;
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int id) throws ParkingLotNotFoundException {
        ParkingLot parkingSpot = parkingLotMap.get(id);
        if(parkingSpot == null){
            throw new ParkingLotNotFoundException("Parking Lot not found for the id : " + id);
        }
        return parkingSpot;
    }

    public void put(ParkingLot parkingLot){
        parkingLot.setId(++parkingLotIdCounter);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
    }
}
