package parkingLot.service.Strategy.BillCalculationStrategy;

import parkingLot.models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    double calculateBillAmount(Ticket ticket, LocalDateTime exitTime);
}
