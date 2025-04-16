package parkingLot.service.Strategy.SlotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(){
        return new NearestSlotAllocationStrategy();
    }

    //TODO : Replace with proper switch case
}
