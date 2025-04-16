package parkingLot.repository;

import parkingLot.exception.GateNotFoundException;
import parkingLot.models.Gate;

import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateMap;
    private static int gateIdCounter;

    public GateRepository() {
        gateIdCounter = 0;
        this.gateMap = new HashMap<>();
    }

    public Gate get(int id) throws GateNotFoundException {
        Gate gate = gateMap.get(id);
        if(gate == null){
            throw new GateNotFoundException("Gate not found for the id : " + id);
        }
        return gate;
    }

    public Gate put(Gate gate){
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
