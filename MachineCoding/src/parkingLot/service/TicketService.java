package parkingLot.service;

import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int gateID, int parkingId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException, NoParkingSlotAvailableException;
}
