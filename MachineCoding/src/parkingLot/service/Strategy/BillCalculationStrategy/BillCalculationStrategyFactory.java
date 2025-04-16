package parkingLot.service.Strategy.BillCalculationStrategy;

public class BillCalculationStrategyFactory {
    //TODO : Add enum for diff strategies, keep it as params and add switch case
    public static BillCalculationStrategy getBillCalculationStrategy(){
        return new LowBillCalculationStrategy();
    }

}
