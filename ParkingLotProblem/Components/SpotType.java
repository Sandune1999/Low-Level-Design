package ParkingLotProblem.Components;

public enum SpotType {
    TWO_WHEELER_SPOT,
    FOUR_WHEELER_SPOT;
    
    public static SpotType getSpotType(VehicleType vType) {
        switch(vType) {
            case TWO_WHEELER: return TWO_WHEELER_SPOT;
            case FOUR_WHEELER: return FOUR_WHEELER_SPOT;
            default: throw new IllegalArgumentException("Unsupported vehicle type." + vType);
        }
    }
}
