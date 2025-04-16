package parkingLot.controller;

import parkingLot.dto.TicketRequestDTO;
import parkingLot.dto.TicketResponseDTO;
import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.models.constants.ParkingSlotStatus;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;
import parkingLot.service.TicketService;
import parkingLot.service.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {
    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.ticketService = new TicketServiceImpl(parkingLotRepository, gateRepository, ticketRepository);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(),
                ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(),
                ticketRequestDTO.getParkingLotId(), LocalDateTime.now());
        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());
        ticket.getParkingSlot().setParkingSlotStatus(ParkingSlotStatus.NOT_AVAILABLE);

        return ticketResponseDTO;
    }
}
