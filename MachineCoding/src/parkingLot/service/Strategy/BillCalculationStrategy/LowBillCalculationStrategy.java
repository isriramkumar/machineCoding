package parkingLot.service.Strategy.BillCalculationStrategy;

import parkingLot.models.Bill;
import parkingLot.models.Ticket;
import parkingLot.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy {
    private static final int PER_HOUR_CHARGE_FOR_2_wheeler = 50;
    private static final int PER_HOUR_CHARGE_FOR_4_wheeler = 100;

    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        LocalDateTime entryTime = ticket.getEntryTime();
        long totalHours = ChronoUnit.HOURS.between(exitTime, entryTime);
        int costPerHour = (ticket.getVehicle().getVehicleType().equals(VehicleType.CAR) ?
                            PER_HOUR_CHARGE_FOR_4_wheeler : PER_HOUR_CHARGE_FOR_2_wheeler);
        double baseCost = totalHours*costPerHour;
        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalHours-1)));
    }
}
