package parkingLot.service;

import parkingLot.models.Gate;
import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSlot;
import parkingLot.models.constants.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingFloorRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.ParkingSlotRepository;
import parkingLot.service.Strategy.BillCalculationStrategy.BillCalculationStrategyFactory;
import parkingLot.service.Strategy.SlotAllocationStrategy.SlotAllocationStrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService{
    private ParkingLotRepository parkingLotRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private GateRepository gateRepository;

    public InitServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, GateRepository gateRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.gateRepository = gateRepository;
    }

    @Override
    public void init() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("ABC Street");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleTypes(new ArrayList<>(Arrays.asList(
                    VehicleType.CAR, VehicleType.BIKE
        )));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy());
        parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getBillCalculationStrategy());

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=0; i<10; i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for(int j=1; j<=10; j++){
                VehicleType supportedVehicleType = j % 2 != 0 ? VehicleType.BIKE : VehicleType.CAR;
                ParkingSlot parkingSlot = new ParkingSlot(i * 100 + j, i * 100 + j, supportedVehicleType);
                parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
                parkingSlots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }

            parkingFloor.setParkingSlots(parkingSlots);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);

            Gate entryGate = new Gate();
            entryGate.setId((i * 10) + 1);
            entryGate.setGateNumber((i * 10) + 1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Rahul");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId((i * 10) + 2);
            exitGate.setGateNumber((i * 10) + 2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("ram");
            exitGate.setParkingLotId(1);
            exitGate.setFloorNumber(i);
            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>(Arrays.asList(entryGate, exitGate));
            parkingFloor.setGate(gates);
            parkingFloorRepository.put(parkingFloor);

            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
