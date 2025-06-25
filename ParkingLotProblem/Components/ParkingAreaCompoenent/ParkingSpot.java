package ParkingLotProblem.Components.ParkingAreaCompoenent;

import ParkingLotProblem.Components.SpotType;

public abstract class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;

    private volatile boolean isOccupied = false;

    ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public String getId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        if(isOccupied) {
            throw new IllegalThreadStateException("Spot already occupied.");
        }
        isOccupied = true;
    }

    public void vacate() {
        if(!isOccupied) {
            throw new IllegalStateException("Spot already empty.");
        }
        isOccupied = false;
    }
}
