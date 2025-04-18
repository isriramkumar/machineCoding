package parkingLot.service;

import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService{
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Vehicle vehicle, int gateID, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException, NoParkingSlotAvailableException {
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        Gate gate = gateRepository.get(gateID);
        ParkingSlot assignedParkingSlot = parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(), parkingLot, gate);
        Ticket ticket = new Ticket();
        ticket.setEntryTime(entryTime);
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(assignedParkingSlot);
        return ticketRepository.put(ticket);
    }
}
