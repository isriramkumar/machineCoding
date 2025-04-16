package parkingLot;

import parkingLot.controller.TicketController;
import parkingLot.dto.TicketRequestDTO;
import parkingLot.dto.TicketResponseDTO;
import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.ParkingLot;
import parkingLot.models.constants.VehicleType;
import parkingLot.repository.*;
import parkingLot.service.InitService;
import parkingLot.service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException, NoParkingSlotAvailableException, GateNotFoundException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSlotRepository  parkingSlotRepository = new ParkingSlotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingLotRepository,
                parkingFloorRepository, gateRepository);
        initService.init();

        ParkingLot parkingLot = parkingLotRepository.get(1);

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("Benz");
        ticketRequestDTO.setColor("Brown");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("5678");

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);

        System.out.println(ticketResponseDTO);
    }
}
