package ParkingLotProblem.Components.ParkingAreaCompoenent;

import ParkingLotProblem.Components.SpotType;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(String id) {
        super(id, SpotType.FOUR_WHEELER_SPOT);
    }
}
