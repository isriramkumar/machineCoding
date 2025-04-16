package parkingLot.repository;

import parkingLot.exception.TicketNotFoundException;
import parkingLot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Integer, Ticket> TicketMap;
    private static int TicketIdCounter;

    public TicketRepository() {
        TicketIdCounter = 0;
        this.TicketMap = new HashMap<>();
    }

    public Ticket get(int id) throws TicketNotFoundException {
        Ticket Ticket = TicketMap.get(id);
        if(Ticket == null){
            throw new TicketNotFoundException("Ticket not found for the id : " + id);
        }
        return Ticket;
    }

    public Ticket put(Ticket Ticket){
        Ticket.setId(++TicketIdCounter);
        TicketMap.put(Ticket.getId(), Ticket);
        return Ticket;
    }
}
